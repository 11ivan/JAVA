package buscaminas;

public class espacio{

    //esta clase se encarga de hacer de cuadradito en el buscaminas(tu sabes donde
    //le das click y booooooooooooooooooooom jajaja)

    private int minasAlrededor;
    private boolean esMina;
    private boolean revelado;
    
    
    //el constructor del espacio 
    public espacio(){        
        minasAlrededor=0;
        esMina=false;
    }
    
    
    //se encarga de decir a un espacio si es mina o no...
    public void colocarMina(){        
        esMina=true;
    }
    
    
    //se encarga de aumentar el munero deminas alrededor de este espacio
    public void aumentarMinas(){        
        if(esMina==false){
            minasAlrededor++;
        }
    }
    
    
    //te dice si el espacio es una mina o no...
    public boolean verMina(){        
        return esMina;
    }
    
    
    //te dice si ya visitaste este espacio mientras estas jugando(en si el programa
    //no te dice nada pero para saber si uno gano si sirve este proceso...
    public boolean verRevelado(){        
        return revelado;
    }
    
    
  //una vez que visites un espacio este cambia su estado a revelado...
    public void cambiarEstado(){       
        revelado=true;
    }
    
    
    
    public String toString(){     
        String res="*";
        if(revelado==true){
            res=""+minasAlrededor;
        }
        if(esMina==true && revelado==true)
        res="X";
        return res;
    }
}
