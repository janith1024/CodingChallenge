package com.jsa;

import com.jsa.entity.Student;
import com.jsa.repository.StudentRepository;
import com.jsa.util.GenericBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodingChallengeApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(CodingChallengeApplication.class, args);
    }

    /**
     * First of all add some sample data to the db to check this application
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        //This is example application so first of all need to remove data if this application ran before
        repository.deleteAll();

        // save some student data to db. Here I use the GenericBuilder implementation to build the Student objects.
        repository.save(GenericBuilder.of(Student::new).with(Student::setFirstName, "Janith")
                .with(Student::setLastName, "Amarasingha").with(Student::setContactNumber, "0716818850")
                .with(Student::setAddress, "53/47 Keenagahalanda wathatha, Kalagedihana.").build());
        repository.save(GenericBuilder.of(Student::new).with(Student::setFirstName, "Sahan")
                .with(Student::setLastName, "Samarasingha").with(Student::setContactNumber, "0716814566")
                .with(Student::setAddress, "Bandarawathhtha, Gampaha.").build());
        repository.save(GenericBuilder.of(Student::new).with(Student::setFirstName, "Sahani")
                .with(Student::setLastName, "Marasingha").with(Student::setContactNumber, "0716814566")
                .with(Student::setAddress, "Bandarawathhtha, Gampaha.").build());

    }
}
