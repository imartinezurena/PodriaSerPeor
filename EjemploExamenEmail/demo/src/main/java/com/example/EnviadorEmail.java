package com.example;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

public class EnviadorEmail implements ObserverEmail {
    private LectorEmail miLector;
    private String usuario;
    private String contrasenia;

    public EnviadorEmail(LectorEmail miLector, String usuario, String contrasenia) {
        this.miLector = miLector;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    @Override
    public void indicarCambioDatagram(String mensaje, String direccion) {
        // usuario contiene también el dominio (@educa.madrid.org)
        String usuarioSolo = usuario.split("@")[0];

        // Código que envía
        Email email = EmailBuilder.startingBlank()
                .to("Spameado", direccion)
                .from("Spameador", usuario)
                .withSubject("Spam")
                .withPlainText(mensaje)
                .buildEmail();

        Mailer mailer = MailerBuilder

                .withSMTPServer("smtp.educa.madrid.org", 587, usuarioSolo, contrasenia)
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .clearEmailValidator() // turns off email validation
                .buildMailer();

        mailer.sendMail(email);

    }
}
