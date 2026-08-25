/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkdlist;

class Student {
    String name;
    int score;
    Student next;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
        this.next = null;
    }
}

class LinkdList {
    Student head;
    public LinkdList(){
        this.head = null;
    }
    
    public void add(String name, int score) {
        Student newStudent = new Student(name, score);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newStudent;
    }
    public void print(){
        Student current= this.head;
        while (current !=null) {
            System.out.println(current.name + " - "+ current.score);
            current = current.next;
        } 
    }
    
    public Student retrieve (String searchedName){
        Student current=this.head;
        while (current != null) {
            if (current.name.equals(searchedName)) {
                return current; 
            }
            current = current.next;
        }
        return null; //not found
    }
    
    public void remove (int n){
        if (head == null || n<0) {return;} //Empty List; index<0; 
        int index=0;
        Student current=head;
        
        while (current != null && index < (n-1)) {            
            current = current.next;
            index++;
        }
        if (current==null || current.next ==null) {
            return; //Position out fo range
        }
        
        current.next= current.next.next;
        
    }
}
public class PruebaLinkedList {

    public static void main(String[] args) {
        LinkdList lista = new LinkdList();
        lista.add("Linus", 90);
        lista.add("Ada", 95);
        lista.add("Paul", 78);
        
        lista.print();
        
        Student found=lista.retrieve("Ada");
        System.out.println("Found: " + found.name + " score: " + found.score);
        
        Student notFound = lista.retrieve("Manuel");
        if (notFound != null) {
            System.out.println("Found: " + notFound.name + " score: " + notFound.score);
        }
        
        lista.remove(2);
        lista.print();
    }
    
   
    
}
