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
    Student tail;
    int index=0;
    public LinkdList(){
        this.head = null;
        this.tail= null;
    }
    
    //To add an student to the list
    public void add(String name, int score) {
        Student newStudent = new Student(name, score);
        if (head == null) {
            head = newStudent;
            tail=newStudent;
            this.index++;
            return;            
        }
        tail.next=newStudent;
        tail= newStudent;
        this.index++;
        
    }
    
    //prints the list
    public void print(){
        Student current= this.head;
        while (current !=null) {
            System.out.println(current.name + " - "+ current.score);
            current = current.next;
        } 
    }
    
    //It is used for searching names
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
    
    //Remove the student
    public void remove (int n){
        if (head == null || n<0) {return;} //Empty List; index<0; 
        if (n>=this.index){return;}
        Student current=head;
        
        if (n==0) { //Remove head
            head = head.next;
            this.index--;
            return;
        }
        
        if (n==-1) {//remove tail
            //Student current =head;
            while (current.next !=tail) {                
                current= current.next;
            }
            current.next=null;
            tail=current;
            index--;
            return;
        }
        
        while (current != null && index < (n-1)) {            
            current = current.next;
            
        }
        if (current==null || current.next ==null) {
            return; //Position out fo range
        }
        
        current.next= current.next.next;
        index--;
        
    }//Close Remove   
}//Close class LinkdList

public class PruebaLinkedList {

    public static void main(String[] args) {
        LinkdList vaciaLista=new LinkdList();
        LinkdList lista = new LinkdList();
        lista.add("Linus", 90);
        lista.add("Ada", 95);
        lista.add("Paul", 78);
        lista.add("Grace", 75);
        
        lista.print();
        
        Student found=lista.retrieve("Ada");
        System.out.println("Found: " + found.name + " score: " + found.score);
        
        Student notFound = lista.retrieve("Manuel");
        if (notFound != null) {
            System.out.println("Found: " + notFound.name + " score: " + notFound.score);
        }
        
        lista.remove(3); // at the end
        lista.remove(0); //at the start
        lista.remove(1); //at the middle
        lista.print();
        
        
        lista.remove(4);
        vaciaLista.remove(0); //empty list
        System.out.println("Intento de borrar lista vacia");
        
        lista.remove(-100); //out of bounds
        System.out.println("Intento de borrar out of bounds");
        
        
        
        
    }  //Close Main
}//Close class PruebaLinkedList
