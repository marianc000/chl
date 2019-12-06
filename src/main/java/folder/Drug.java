/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

/**
 *
 * @author mcaikovs
 */
public enum Drug {

    Aspirin("As"),
    Antibiotic("An"),
    Insulin("I"),
    Paracetamol("P");
    
    String abbreviation;

    private Drug(String abbreviation) {
        this.abbreviation = abbreviation;
    }

}
