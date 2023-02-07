package main;

public class NotaseMoedas {

	public static String billsAndCoins(double input) {
    	
    	//Notas
    	Double aux;
    	int qtd_nota100;
        int qtd_nota50;
        int qtd_nota20;
        int qtd_nota10;
        int qtd_nota5;
        int qtd_nota2;
        // Moedas
        int qtd_moeda1;
        int qtd_moeda0_5;
        int qtd_moeda0_25;
        int qtd_moeda0_10;
        int qtd_moeda0_05;
        int qtd_moeda0_01;
        
        aux = input / 100;  
        qtd_nota100 = aux.intValue();
        input = input -(qtd_nota100 * 100);
        
        aux = input / 50;  
        qtd_nota50 = aux.intValue();
        input = input -(qtd_nota50 * 50);
        
        aux = input / 20;  
        qtd_nota20 = aux.intValue();
        input = input -(qtd_nota20 * 20);
        
        aux = input / 10;  
        qtd_nota10 = aux.intValue();
        input = input -(qtd_nota10 * 10);
        
        aux = input / 5;  
        qtd_nota5 = aux.intValue();
        input = input -(qtd_nota5 * 5);
 
        aux = input / 2;  
        qtd_nota2 = aux.intValue();
        input = input -(qtd_nota2 * 2);
        
        //===================================================
        
        aux = input / 1;  
        qtd_moeda1 = aux.intValue();
        input = input -(qtd_moeda1 * 1);
        
        aux = input / 0.50;  
        qtd_moeda0_5 = aux.intValue();
        input = input -(qtd_moeda0_5 * 0.50);
        
        aux = input / 0.25;  
        qtd_moeda0_25 = aux.intValue();
        input = input -(qtd_moeda0_25 * 0.25);
        
        aux = input / 0.10;  
        qtd_moeda0_10 = aux.intValue();
        input = input -(qtd_moeda0_10 * 0.10);
        
        aux = input / 0.05;  
        qtd_moeda0_05 = aux.intValue();
        input = input -(qtd_moeda0_05 * 0.05);
        
        aux = input / 0.01;  
        qtd_moeda0_01 = aux.intValue();
        input = input -(qtd_moeda0_01 * 0.01);
        
        return ""+"NOTAS:\n"+qtd_nota100 + " nota(s) de R$ 100.00\n" 
        	+ qtd_nota50 + " nota(s) de R$ 50.00\n"
        	+ qtd_nota20 + " nota(s) de R$ 20.00\n"
        	+ qtd_nota10 + " nota(s) de R$ 10.00\n"
        	+ qtd_nota5 + " nota(s) de R$ 5.00\n"
        	+ qtd_nota2 + " nota(s) de R$ 2.00\n"
        	+"MOEDAS:\n"
        	+ qtd_moeda1 + " moeda(s) de R$ 1.00\n"
        	+ qtd_moeda0_5 + " moeda(s) de R$ 0.50\n"
        	+ qtd_moeda0_25 + " moeda(s) de R$ 0.25\n"
        	+ qtd_moeda0_10 + " moeda(s) de R$ 0.10\n"
        	+ qtd_moeda0_05 + " moeda(s) de R$ 0.05\n"
        	+ qtd_moeda0_01 + " moeda(s) de R$ 0.01\n"
        	+
        "";
    }
    public static void main(String[] args) {
        System.out.println(billsAndCoins(91.01));
    }
}
