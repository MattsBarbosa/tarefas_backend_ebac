/**
 * 
 */
package java.br.com.rpires;

import java.br.com.rpires.ClienteServiceTest;
import java.br.com.rpires.ProdutoDAOTest;
import java.br.com.rpires.ProdutoServiceTest;
import java.br.com.rpires.VendaDAOTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author rodrigo.pires
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ ClienteServiceTest.class, ClienteDAOTest.class,
	ProdutoServiceTest.class, ProdutoDAOTest.class,
	VendaDAOTest.class})
public class AllTests {

}
