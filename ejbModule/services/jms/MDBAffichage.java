package services.jms;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
//Déclarer un MDB (consommateur en écoute de messages JMS)
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
//le nom JNDI de la destination à partir de la quelle le bean consomme les messages
mappedName = "affichageQueue")
public class MDBAffichage implements MessageListener {
//Constructeur
public MDBAffichage() {
System.out.println("MDBAffichage:.....");
}
//méthode à déclencher lors de la réception d'un message
public void onMessage(Message message) {
TextMessage texte =(TextMessage)message;
try {
System.out.println("Réception[MDBAffichage]: "+texte.getText());
} catch (JMSException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
}