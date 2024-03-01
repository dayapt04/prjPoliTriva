package BusinessLogic;
public class MenuCategoria {
    public void showMenuPrincipal(){
       System.out.println("1. Individual \n2. Multijugador");
    }

    public void showMenuCategoria() {
        System.out.println("Seleccione la Tematica deseada");
        System.out.println("1. Cultura General Politecnica \n2. Politecnico Basico \n3. Revisar Puntajes de la Partida");
    }

    public void showCulturaGeneral() {

        
    }

    public void showMenuSubtema(int categoria){

        if (categoria == 1){
            System.out.println("Seleccione la categoria que le gustaria jugar");
            System.out.println(
                    "1. Cultura General Estudiantil \n2. Cultura General Institucional \n3. Regresar");
        
        }else if (categoria == 2) {
            System.out.println("Seleccione la categoria que le gustaria jugar");
            System.out.println("1. Algebra Lineal\n" +
                    "2. Calculo en una variable\n" +
                    "3. Mecanica Newtoniana\n" +
                    "4. COE\n" +
                    "5. Analisis Socioeconomico\n" + "6. Regresar");}{

          
        }



    }
}
