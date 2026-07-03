package Generics;

import java.util.*;

// Abstract Class
abstract class JobRole {

    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}

// Job Roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

// Generic Class
class Resume<T extends JobRole> {

    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public void displayResume() {
        System.out.println("Candidate Name : " + candidateName);
        System.out.println("Applied Role   : " + jobRole.getRoleName());
        System.out.println();
    }

    public T getJobRole() {
        return jobRole;
    }
}

public class AIDrivenResumeScreeningSystem {

    // Generic Method
    public static <T extends JobRole> void processResume(Resume<T> resume) {
        System.out.println("Resume Processed Successfully!");
        resume.displayResume();
    }

    // Wildcard Method
    public static void displayJobRoles(List<? extends JobRole> roles) {
        System.out.println("Available Job Roles:");
        for (JobRole role : roles) {
            System.out.println(role.getRoleName());
        }
    }

    public static void main(String[] args) {

        Resume<SoftwareEngineer> r1 = new Resume<>("Anjali", new SoftwareEngineer());

        Resume<DataScientist> r2 = new Resume<>("Rahul", new DataScientist());

        Resume<ProductManager> r3 = new Resume<>("Priya", new ProductManager());

        processResume(r1);
        processResume(r2);
        processResume(r3);

        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(new SoftwareEngineer());
        jobRoles.add(new DataScientist());
        jobRoles.add(new ProductManager());

        System.out.println();
        displayJobRoles(jobRoles);
    }
}