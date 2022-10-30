package p3examtest;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = "p3examtest.Dao")
public class E4111Application {

	public static void main(String[] args) {
		SpringApplication.run(E4111Application.class, args);
	}

}
