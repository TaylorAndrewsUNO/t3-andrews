package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE SocialMediaOut (
  id INT NOT NULL AUTO_INCREMENT,    
  name VARCHAR(30) NOT NULL, 
  post VARCHAR(60) NOT NULL,  
  time VARCHAR(30) NOT NULL,  
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "SocialMediaOut")
public class SocialMediaOut {

   @Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id") // specify the column name. Without it, it will use method name
   private Integer id;

   @Column(name = "name")
   private String name;

   @Column(name = "post")
   private String post;
   
   @Column(name = "time")
   private String time;

   public SocialMediaOut() {
   }

   public SocialMediaOut(Integer id, String name, String post, String time) {
      this.id = id;
      this.name = name;
      this.post = post;
      this.time = time;
   }

   public SocialMediaOut(String name, String post, String time) {
      this.name = name;
      this.post = post;
      this.time = time;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
   
   public String getPost() {
	   return post;
   }
   
   public void setPost(String post) {
	   this.post = post;
   }
   
   public String getTime() {
	   return time;
   }
   
   public void setTime(String time) {
	   this.time = time;
   }

   @Override
   public String toString() {
      return "Employee: " + this.id + ", " + this.name + ", " + this.post + ", " + this.time;
   }
}