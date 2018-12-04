package .com.serverless.exercicio;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;


import Lombok.AllArgsConstructor;
import Lombok.Data;


    @Data
    @AllArgsConstructor
    class Cidade {

    private Long id;
    private String nome;
    private Estado estado;


    }
    @Data
    @AllArgsConstructor
    class Estado {

    private Long id;
    private String nome;

}

    public class Function{


        @FunctionName("create-cidade"){

            public Cidade createCidade(@HttpTrigger(name = "createCidade", methods = {HttpMethod.POST}, route = "cidade") Cidade cidade){

                cidade.setId(100L);
                
                return cidade;
            }

        @FunctionName("read-cidade"){

            public List<Cidade> readCidade(@HttpTrigger(name = "readCidade", methods = (HttpMethod.GET), route ="cidade") String cidade){

                return Stream.of(
                    new Cidade(1L, "Torrinha", new Estado(1L, "Sao Paulo"))
                    new Cidade(2L, "Cornelio", new Estado(2L, "Parana"))
                ).collect(Collectors.toList());
                
            }
        }

        @FunctionName("edit-cidade"){

            public Cidade editCidade(@HttpTrigger(name = "editCidade", methods = { HttpMethod.PUT}, route = "cidade") Cidade cidade){
                
                return cidade;
            }
        }

        @FunctionName("delete-cidade"){

            public int deleteCidade(@HttpTrigger(name = "deleteCidade"), methods = { HttpMethod.DELETE}, route = "cidade/{id}" Long id){

                return 200;
            }
        }
        }
    }

    }


