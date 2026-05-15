package notification_platform.Entities;

public class Client implements Entity{
    
    private String name;
    private String surname;
    private Company company;
    private Integer number;
    private String email;

    public Client(){};

    public Client(String name, String surname, Company company, Integer number, String email){
        this.name = name;
        this.surname = surname;
        this.company = company;
        this.number = number;
        this.email = email;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }
    
    public Company getCompany(){
        return this.company;
    }

    public Integer getNumber(){
        return this.number;
    }

    public String getEmail(){
        return this.email;
    }

}

