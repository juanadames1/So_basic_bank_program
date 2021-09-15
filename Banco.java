//Juan Camilo Adames Pardo, Sebastián Colantoni

package nivel2;

import javax.swing.*;
import java.util.Arrays;
class Banco {
    private String[][] cuentas;
    private String[][] movimientos;
    private int posCuentas;
    private int posMovis;
    public static void main(String[] X) {
        new Banco();
    }
    public Banco (){
        this.cuentas = new String[10][3];
        this.movimientos = new String[10][3];
        this.posCuentas=0;
        this.posMovis=0;
        this.menu();
    }
    private void menu() { //Creación del método Menú
        int opcion;
        String x;
        do {
            x = JOptionPane.showInputDialog("======== Opciones ======== \n" +
                    "1. Crear nueva cuenta \n" +
                    "2. Depositar dinero en cuenta \n" +
                    "3. Retiro de dinero en cuenta \n" +
                    "4. Consultar saldo de la cuenta \n" +
                    "5. Consultar movimientos de la cuenta\n" +
                    "6. Consultar cuenta \n" +
                    "7. Ver todas las cuentas registradas \n" +
                    "0. SALIR \n");
            char y = x.charAt(0);
            opcion = Character.getNumericValue(y);
            switch (opcion) {
                case 1:
                    this.nuevaCuenta();
                    break;
                case 2:
                    if(cuentas[0][0] == null){
                        JOptionPane.showMessageDialog(null, "No hay cuentas creadas, por favor dirijase a la opción 1");
                        break;
                    }else{
                        this.deposito();
                    }
                    
                    break;
                case 3:
                if(cuentas[0][0] == null){
                    JOptionPane.showMessageDialog(null, "No hay cuentas creadas, por favor dirijase a la opción 1");
                    break;
                }else{
                    this.Retiro();
                }
                    break;
                case 4:
                if(cuentas[0][0] == null){
                    JOptionPane.showMessageDialog(null, "No hay cuentas creadas, por favor dirijase a la opción 1");
                    break;
                }else{
                    this.consultarSaldo();
                }
                    break;
                case 5:
                    if(cuentas[0][0] == null) {
                        JOptionPane.showMessageDialog(null, "No hay cuentas creadas, por favor dirijase a la opción 1");
                        break;
                    }else{
                        this.consultarMovimientos();
                        }
                case 6:
                if(cuentas[0][0] == null){
                    JOptionPane.showMessageDialog(null, "No hay cuentas creadas, por favor dirijase a la opción 1");
                    break;
                }else{
                    this.verCuenta();
                }
                    break;
                case 7:
                if(cuentas[0][0] == null){
                    JOptionPane.showMessageDialog(null, "No hay cuentas creadas, por favor dirijase a la opción 1");
                    break;
                }else{
                    this.verTodas();
                }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "No existe");
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Vemos my lof");
                    break;
            }
        }
        while (opcion != 0);
    }
    private void nuevaCuenta(){
        int id;
        String acum, claveS, saldoS;
        int saldo;
        
        id = Integer.parseInt(JOptionPane.showInputDialog("Id"));

        acum = String.valueOf(id);
        cuentas[posCuentas][0] = acum;
        

        char pos1 = acum.charAt(0);
        char pos2 = acum.charAt(1);
        int random = (int)(Math.random()*99+10);

        claveS = String.valueOf(pos1) + String.valueOf(pos2) + String.valueOf(random);
        cuentas[posCuentas][1] = claveS;

        saldo=Integer.parseInt(JOptionPane.showInputDialog("Gracias, ahora ingrese un saldo inicial"));

        while(saldo <= 0){
            saldo=Integer.parseInt(JOptionPane.showInputDialog("Valor inválido, vuelva a intentar"));
        }

        saldoS = String.valueOf(saldo);

        cuentas[posCuentas][2] = saldoS;

        posCuentas++;

        this.menu();
        



    }

    private void deposito(){
        int clave, monto;
        String claveS, montoS, acum;

        clave = Integer.parseInt(JOptionPane.showInputDialog("Digite su clave"));
        claveS = String.valueOf(clave);
        
        for (int i = 0; i <= 10; i ++){
            if(cuentas[i][1].equals(claveS)){
                monto = Integer.parseInt(JOptionPane.showInputDialog("Diga cuánto quiere agregar a su cuenta"));
                while(monto <= 0){
                    monto = Integer.parseInt(JOptionPane.showInputDialog("Valor inválido"));
                }
                acum = cuentas[i][2];
                monto += Integer.parseInt(acum);
                montoS = String.valueOf(monto);
                cuentas[i][2] = "" + montoS;
                System.out.println(cuentas[i][2]);
                break;
            }
        }
        this.menu();
    }
    private void Retiro(){
        int clave, monto, acumNum;
        String claveS, montoS, acum;

        clave = Integer.parseInt(JOptionPane.showInputDialog("Digite su clave"));
        claveS = String.valueOf(clave);
        
        for (int i = 0; i <= 9; i ++){
            if(cuentas[i][1].equals(claveS)){
                monto = Integer.parseInt(JOptionPane.showInputDialog("Diga cuánto quiere retirar de su cuenta"));
                while(monto <= 0){
                    monto = Integer.parseInt(JOptionPane.showInputDialog("Valor inválido"));
                }

                acumNum = Integer.parseInt(cuentas[i][2]);
                while(acumNum < monto){
                    monto = Integer.parseInt(JOptionPane.showInputDialog("Saldo insuficiente en cuenta"));
                }
                acum = cuentas[i][2];
                monto = Integer.parseInt(acum) - monto;
                montoS = String.valueOf(monto);
                cuentas[i][2] = "" + montoS;
                System.out.println(cuentas[i][2]);
                break;
            }
        }
        this.menu();
    }
    private void verCuenta(){
        int id;
        String idS;

        id = Integer.parseInt(JOptionPane.showInputDialog("Diga el id de la cuenta a consultar"));

        idS = String.valueOf(id);

        for(int i = 0; i <= 9; i++){
            if(cuentas[i][0].equals(idS)){
                System.out.println(cuentas[i][0] + " " + cuentas[i][1] + " " + cuentas[i][2]);
                break;
            }
        }

        this.menu();
    }
    private void verTodas(){
        
        for (int i = 0; i <= 9; i ++){
            if(cuentas[i][0] == null){
                continue;
            }
            System.out.println(cuentas[i][0] + " " + cuentas[i][1] + " " + cuentas[i][2]);
        }
        this.menu();
    }
    
    private void consultarSaldo(){
        int clave;
        String claveS;

        clave = Integer.parseInt(JOptionPane.showInputDialog("Digite su clave"));
        claveS = String.valueOf(clave);
        
        for (int i = 0; i <= 9; i ++){
            if(cuentas[i][1].equals(claveS)){
                System.out.println(cuentas[i][2]);
                break;
            }
        }
        this.menu();
    }
    private void consultarMovimientos(){
        }
    }