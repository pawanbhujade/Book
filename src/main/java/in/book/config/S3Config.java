package in.book.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;



@Configuration
public class S3Config {
	
	@Value("${access_key}")
	private String accesskey;
	
	@Value("${secretkey}")
	private String secretkey;
	
	@Value("${region}")
	private String region;
	
	@Bean
	public AmazonS3 S3() {
		AWSCredentials awsCredentials=new BasicAWSCredentials(accesskey, secretkey);
		
		return AmazonS3ClientBuilder.standard()
				.withRegion(region)
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
				.build();
	}

}
