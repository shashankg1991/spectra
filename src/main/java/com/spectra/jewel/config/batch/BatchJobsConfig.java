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
import com.spectra.jewel.data.CollectionGroupData;
import com.spectra.jewel.data.ItemCollectionData;
import com.spectra.jewel.data.ProductData;
import com.spectra.jewel.model.collections.CollectionGroup;
import com.spectra.jewel.model.collections.ItemCollection;
import com.spectra.jewel.model.product.Product;

@Configuration
@EnableBatchProcessing
public class BatchJobsConfig {

	@Value("${batch.archive.directory}")
	private String archiveDirectory;

	/***************** Product Import *******************/
	@Bean
	public Job productImportJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			ItemReader<ProductData> productItemReader, ItemProcessor<ProductData, Product> productDataItemProcessor,
			ItemWriter<Product> productDBWriter, @Value("${batch.product.input.file}") String path) {
		FileArchivingTasklet fileArchivingTasklet = new FileArchivingTasklet(path, archiveDirectory);
		Step loadStep = stepBuilderFactory.get("products-file-load").<ProductData, Product>chunk(1)
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
	public Job collectionImportJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			ItemReader<ItemCollectionData> collectionItemReader,
			ItemProcessor<ItemCollectionData, ItemCollection> collectionDataItemProcessor,
			ItemWriter<ItemCollection> collectionDBWriter, @Value("${batch.collection.input.file}") String path) {
		FileArchivingTasklet fileArchivingTasklet = new FileArchivingTasklet(path, archiveDirectory);
		Step loadStep = stepBuilderFactory.get("collections-file-load").<ItemCollectionData, ItemCollection>chunk(1)
				.reader(collectionItemReader).processor(collectionDataItemProcessor).writer(collectionDBWriter).build();
		Step archiveStep = stepBuilderFactory.get("archive-collection-file").tasklet(fileArchivingTasklet).build();
		return jobBuilderFactory.get("Collections-Load").incrementer(new RunIdIncrementer()).start(loadStep)
				.next(archiveStep).build();
	}

	@Bean
	public FlatFileItemReader<ItemCollectionData> collectionItemReader(
			@Value("${batch.collection.input.file}") String path) {
		FlatFileItemReader<ItemCollectionData> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new FileSystemResource(path));
		flatFileItemReader.setName("Collection-Reader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(collectionLineMapper());
		flatFileItemReader.setStrict(false);
		return flatFileItemReader;
	}

	@Bean
	public LineMapper<ItemCollectionData> collectionLineMapper() {
		DefaultLineMapper<ItemCollectionData> defaultLineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] { "code", "name" });
		BeanWrapperFieldSetMapper<ItemCollectionData> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(ItemCollectionData.class);
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		return defaultLineMapper;
	}

	/***************** Collection Group Import *******************/
	@Bean
	public Job collectionGroupImportJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			ItemReader<CollectionGroupData> collectionGroupReader,
			ItemProcessor<CollectionGroupData, CollectionGroup> collectionGroupDataItemProcessor,
			ItemWriter<CollectionGroup> collectionGroupDBWriter,
			@Value("${batch.collectiongroup.input.file}") String path) {
		FileArchivingTasklet fileArchivingTasklet = new FileArchivingTasklet(path, archiveDirectory);
		Step loadStep = stepBuilderFactory.get("collectiongroup-file-load")
				.<CollectionGroupData, CollectionGroup>chunk(1).reader(collectionGroupReader)
				.processor(collectionGroupDataItemProcessor).writer(collectionGroupDBWriter).build();
		Step archiveStep = stepBuilderFactory.get("archive-collectiongroup-file").tasklet(fileArchivingTasklet).build();
		return jobBuilderFactory.get("CollectionGroup-Load").incrementer(new RunIdIncrementer()).start(loadStep)
				.next(archiveStep).build();
	}

	@Bean
	public FlatFileItemReader<CollectionGroupData> collectionGroupItemReader(
			@Value("${batch.collectiongroup.input.file}") String path) {
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
