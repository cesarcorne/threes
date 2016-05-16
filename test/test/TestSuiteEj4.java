package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Esta suite de tests la creamos para correr en conjunto 
 * la suite PartitionTest correspondiente al ejercicio 3
 * con la nueva suite de test para medir la cobertura pedida en el ejercicio4.
 * */

@RunWith(Suite.class)
@SuiteClasses({BranchTest.class,
				PartitionTest.class})
public class TestSuiteEj4 {

}
