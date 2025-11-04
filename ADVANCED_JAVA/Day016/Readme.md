# Whenever we Building REST CONTROLLER

1. First write the Dao layer  which extends from the crud repo which comming from 
import org.springframework.data.repository.CrudRepository;

and add the class level annotation which is @Repository which help to add this repo in bean to identif and help to inject dependency


2. then start writing the Service layer where we only add the annotation at the service implement class
@Service annotation
then write the methods 

3. now in the controller add class level annotation
which will be @RestController -> its consist of @Controller + @ResponseBody
add the class level annotation

when doing the post or receiving the data from the user @RequestBody Restaurant newRestauant do this 
add anotation and then give object entity type and also ref to store the data
done

Repository -> Service -> Controller


# Project Tip
1. instead of sending body , send resp packet
use the responseEntity class to setup response packet

incase of no available restaturent 
 - sc 204
 
incase of  available restaturent 
 - sc 200 , resp body - list




