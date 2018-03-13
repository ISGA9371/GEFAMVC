//Variables globales

//Funciones
function botonIr(seleccion){

    ventana="";

    if(seleccion=="F"){
        ventana=document.getElementById("ventanaIr").value;
        document.getElementById("ventanaIrP").value="";
    }else{
        ventana=document.getElementById("ventanaIrP").value;
        document.getElementById("ventanaIr").value="";
    }

    if(ventana!=""){

       window.location="/buscar?nomVentana="+ventana+"&seleccion="+seleccion;

    }



}