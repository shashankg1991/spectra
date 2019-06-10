package com.spectra.jewel.config.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.spectra.jewel.batch.FileArchivingTasklet;
import com.spectra.jewel.data.ProductData;
import com.spectra.jewel.model.Product;

@Configuration
@EnableBatchProcessing
public class BatchJobsConfig {
	
	@Value("${batch.archive.directory}")
	private String archiveDirectory;
	
	@Bean
	public Job productImportJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			ItemReader<ProductData> productItemReader, ItemProcessor<ProductData, Product> productDataItemProcessor,
			ItemWriter<Product> productDBWriter, @Value("${batch.product.input.file}") String path) {

		FileArchivingTasklet fileArchivingTasklet = new FileArchivingTasklet(path,archiveDirectory);
		Step loadStep = stepBuilderFactory.get("products-file-load").<ProductData, Product>chunk(100)
				.reader(productItemReader).processor(productDataItemProcessor).writer(productDBWriter).build();
		Step archiveStep = stepBuilderFactory.get("archive-products-file").tasklet(fileArchivingTasklet).build();
		return jobBuilderFactory.get("Product-Load").incrementer(new RunIdIncrementer()).start(loadStep)
				.next(archiveStep).build();
	}

	@Bean
	public FlatFileItemReader<ProductData> productItemReader(@Value("${batch.product.input.file}") String path) {

		FlatFileItemReader<ProductData> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new FileSystemResource(path));
		flatFileItemReader.setName("Product-Reader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(productLineMapper());
		return flatFileItemReader;
	}

	@Bean
	public LineMapper<ProductData> productLineMapper() {

		DefaultLineMapper<ProductData> defaultLineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] { "name", "description" });

		BeanWrapperFieldSetMapper<ProductData> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(ProductData.class);

		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);

		return defaultLineMapper;
	}
}
