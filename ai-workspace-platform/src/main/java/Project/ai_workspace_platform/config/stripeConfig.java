package Project.ai_workspace_platform.config;

import com.stripe.Stripe;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class stripeConfig {
    @Value("${stripe.secretKey}")
    private String stripeSecretKey;


    @PostConstruct
    public void init(){
        Stripe.apiKey=stripeSecretKey;
    }
}
