package fpt.spring.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"fpt.spring"})
@EnableTransactionManagement
public class JPAUtils {
	
	//find: tim kiem
	//refresh: cap nhat
	//persist: them
	//merge: chinh sua
	//remove: xoa
	//clear: xoa het
	//close: dong
	
	//getResultList: tra ve danh sach ket qua
	//getSingleResult: tra ve ket qua don
	//setParamater: thiet lap tham so
	//setFirstResult: thiet lap ket qua dau tien
	//setMaxResult: thiet lap so luong tra ve ket qua
	
	//GET: client lay du lieu tu server
	//POST: client dua du lieu toi server
	//DELETE: client yeu cau xoa du lieu
	//PUT: client yeu cau sua du lieu
	
	@Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("Spring_MVC_ShopFPT_1.0");
          
        return factoryBean;
    }
      
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
          
        return transactionManager;
    } 

	@Bean
	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Spring_MVC_ShopFPT_1.0");
		
		return factory.createEntityManager();
	}
}
