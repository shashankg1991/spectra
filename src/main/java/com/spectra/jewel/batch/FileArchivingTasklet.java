package com.spectra.jewel.batch;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.UnexpectedJobExecutionException;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

public class FileArchivingTasklet implements Tasklet, InitializingBean {

	private String archiveDirectory;
	private String filePath;

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(filePath, "file must be set");
	}

	public FileArchivingTasklet(String filePath, String archiveDirectory) {
		this.filePath = filePath;
		this.archiveDirectory = archiveDirectory;
	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		Resource fileResource = new FileSystemResource(filePath);
		if (fileResource.exists()) {
			File file = fileResource.getFile();
			archiveFile(file);
			boolean deleted = file.delete();
			if (!deleted) {
				throw new UnexpectedJobExecutionException("Could not delete file " + file.getPath());
			} else {
				System.out.println(file.getPath() + " is deleted!");
			}
		}
		return RepeatStatus.FINISHED;
	}

	private void archiveFile(File source) throws IOException {
		File target = new File(archiveDirectory + source.getName() + System.currentTimeMillis());
		FileUtils.copyFile(source, target);
	}
}