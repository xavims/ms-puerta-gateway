package es.indra.curso.mspuertagateway.filters;

import java.io.PrintStream;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class MedirTiempoFilter implements GlobalFilter, Ordered {

    
    // Mono : programacion reactiva de un elemento.
    // Flux: programacion reactiva de varios elementos.
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //configuramos que hacemos en el pre y en el post

        // * pre: tomar el tiempo de inicio
        Long tiempoInicio = System.currentTimeMillis();

        // * post: lo que se ejecuta en el then()
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                Long tiempoFinal = System.currentTimeMillis();
                System.out.println("--------------------------");
                System.out.println("Tiempo trasncurrido: " + (tiempoFinal - tiempoInicio) + " mseg");
                System.out.println("--------------------------");
            })
        );  //fin del then
    }

    @Override
    public int getOrder() {
        // orden de ejecucion en el caso de tener varios filtros
        return 1;
    }
    

}
