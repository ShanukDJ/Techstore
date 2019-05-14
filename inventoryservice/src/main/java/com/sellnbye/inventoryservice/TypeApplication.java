/**
 * 
 */
package com.sellnbye.inventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Janandhi Chamudika
 *
 */

@SpringBootApplication
@EnableJpaAuditing
public class TypeApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(TypeApplication.class, args);

	}

}
