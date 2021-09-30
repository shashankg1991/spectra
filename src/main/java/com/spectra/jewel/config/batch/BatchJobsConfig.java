package com.spectra.jewel.config.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
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

import com.spectra.jewel.data.CategoryData;
import com.spectra.jewel.data.CollectionGroupData;
import com.spectra.jewel.data.ProductData;
import com.spectra.jewel.model.product.Category;
import com.spectra.jewel.model.product.Product;

@Configuration
@EnableBatchProcessing
public class BatchJobsConfig {
	/***************** Product Import *******************/
	@Bean
	public Job productImportJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			ItemReader<ProductData> productItemReader, ItemProcessor<ProductData, Product> productDataItemProcessor,
			ItemWriter<Product> productDBWriter) {
		Step loadStep = stepBuilderFactory.get("products-file-load").<ProductData, Product>chunk(1)
				.reader(productItemReader).processor(productDataItemProcessor).writer(productDBWriter).build();
		return jobBuilderFactory.get("Product-Load").incrementer(new RunIdIncrementer()).start(loadStep).build();
	}

	@Bean
	@StepScope
	public FlatFileItemReader<ProductData> productItemReader(@Value("#{jobParameters['file.name']}") String path) {
		FlatFileItemReader<ProductData> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new FileSystemResource(path));
		flatFileItemReader.setName("Product-Reader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(productLineMapper());
		flatFileItemReader.setStrict(false);
		return flatFileItemReader;
	}

	@Bean
	public LineMapper<ProductData> productLineMapper() {
		DefaultLineMapper<ProductData> defaultLineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] { "code", "grossWeight", "name", "description", "collectionsString" });
		BeanWrapperFieldSetMapper<ProductData> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(ProductData.class);
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		return defaultLineMapper;
	}

	/***************** Collection Import *******************/

	@Bean
	public Job categoryImportJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			ItemReader<CategoryData> categoryReader, ItemProcessor<CategoryData, Category> categoryDataItemProcessor,
			ItemWriter<Category> categoryDBWriter) {
		Step loadStep = stepBuilderFactory.get("category-file-load").<CategoryData, Category>chunk(1)
				.reader(categoryReader).processor(categoryDataItemProcessor).writer(categoryDBWriter).build();
		return jobBuilderFactory.get("Categories-Load").incrementer(new RunIdIncrementer()).start(loadStep).build();
	}

	@Bean
	@StepScope
	public FlatFileItemReader<CategoryData> categoryReader(@Value("#{jobParameters['file.name']}") String path) {
		FlatFileItemReader<CategoryData> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new FileSystemResource(path));
		flatFileItemReader.setName("Category-Reader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(collectionLineMapper());
		flatFileItemReader.setStrict(false);
		return flatFileItemReader;
	}

	@Bean
	public LineMapper<CategoryData> collectionLineMapper() {
		DefaultLineMapper<CategoryData> defaultLineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] { "code", "name" });
		BeanWrapperFieldSetMapper<CategoryData> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(CategoryData.class);
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		return defaultLineMapper;
	}

	@Bean
	@StepScope
	public FlatFileItemReader<CollectionGroupData> collectionGroupItemReader(
			@Value("#{jobParameters['file.name']}") String path) {
		FlatFileItemReader<CollectionGroupData> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new FileSystemResource(path));
		flatFileItemReader.setName("CollectionGroup-Reader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(collectionGroupLineMapper());
		flatFileItemReader.setStrict(false);
		return flatFileItemReader;
	}

	@Bean
	public LineMapper<CollectionGroupData> collectionGroupLineMapper() {
		DefaultLineMapper<CollectionGroupData> defaultLineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] { "code", "name", "collectionItemsString" });
		BeanWrapperFieldSetMapper<CollectionGroupData> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(CollectionGroupData.class);
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		return defaultLineMapper;
	}
}
