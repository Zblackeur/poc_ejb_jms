package services.jms;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
//D�clarer un MDB (consommateur en �coute de messages JMS)
@MessageDriven(
activationConfig =
{
//Destination: queue
@ActivationConfigProperty(
propertyName = "destination",
propertyValue = "affichageQueue"),
@ActivationConfigProperty(
propertyName = "destinationType",
propertyValue = "javax.jms.Queue")
},
//le nom JNDI de la destination � partir de la quelle le bean consomme les messages
mappedName = "affichageQueue")
public class MDBAffichage implements MessageListener {
//Constructeur
public MDBAffichage() {
System.out.println("MDBAffichage:.....");
}
//m�thode � d�clencher lors de la r�ception d'un message
public void onMessage(Message message) {
TextMessage texte =(TextMessage)message;
try {
System.out.println("R�ception[MDBAffichage]: "+texte.getText());
} catch (JMSException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
}