/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;


/**
 *
 * @author phamt
 */
public class studenmanagement {

        long MSSV;
        String Name,Gender,Email,Phone,Address;
        public studenmanagement() {
    
}

    public studenmanagement(long MSSV, String Name, String Gender, String Email, String Phone, String Address) {
        this.MSSV = MSSV;
        this.Name = Name;
        this.Gender = Gender;
        this.Email = Email;
        this.Phone = Phone;
        this.Address = Address;
    }

    public studenmanagement(String Name, String Gender, String Email, String Phone, String Address) {
        this.Name = Name;
        this.Gender = Gender;
        this.Email = Email;
        this.Phone = Phone ;
        this.Address = Address;
    }

    public long getMSSV() {
        return MSSV;
    }

    public void setMSSV(long MSSV) {
        this.MSSV = MSSV;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    
    
}
