package .com.serverless.exercicio;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;


import Lombok.AllArgsConstructor;
import Lombok.Data;
import Lombok.NoArgsConstructor;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Cidade {

    private UUID id;
    private String nome;
    private Estado estado;


    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Estado {

    private UUID id;
    private String nome;

}

    public class DAO{


        @FunctionName("create-cidade"){

            public Cidade createCidade(@HttpTrigger(name = "createCidade", methods = {HttpMethod.POST}, route = "cidade") Cidade cidade){

                cidade.setId(UUID.randomUUID());
                return cidade;
            }

        @FunctionName("read-cidade"){

            public List<Cidade> readCidade(@HttpTrigger(name = "readCidade", methods = (HttpMethod.GET), route ="cidade") String cidade){

                return Stream.of(new Cidade("Torrinha", new Estado("Sao Paulo"))).collect(Collectors.toList());
                
            }
        }

        @FunctionName("edit-cidade"){

            public Cidade editCidade(@HttpTrigger(name = "editCidade", methods = { HttpMethod.PUT}, route = "cidade") Cidade cidade){


                cidade.setNome(cidade.getNome());
                return cidade;
            }
        }

        @FunctionName("delete-cidade"){

            public String deleteCidade(@HttpTrigger(name = "deleteCidade"), methods = { HttpMethod.DELETE}, route = "cidade/{id}" int id){

                return 200;
            }
        }
        }
    }

    }


