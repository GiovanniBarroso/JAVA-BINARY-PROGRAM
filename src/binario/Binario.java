package binario;
import java.util.*;
public class Binario {

	public static void main(String[] args) {

		Scanner sn = new Scanner(System.in);
		int option = 0, numero = 0;

		do {

			System.out.println("CALCULADORA DE NUMEROS BINARIOS.");
			System.out.println("\n");
			System.out.println("1. Dime un número para pasarlo de decimal a binario");
			System.out.println("2. Dime un número para pasarlo de binario a decimal");
			System.out.println("3. Cerrar el programa.");

			try {
				String opt = "";
				opt = sn.nextLine().replaceAll(" ", "");
				option = Integer.parseInt(opt);

				switch (option) {
				case 1 :
					System.out.println("Pasar de numero decimal a binario");
					System.out.println("Dime un número para pasarlo a binario");

					try {
						String numero1 = sn.nextLine().replaceAll(" ", "");
						numero = Integer.parseInt(numero1);
						esBinario(numero);

					} catch (NumberFormatException e) {
						System.out.println("Error, dame un valor numérico.");

					}
					if (numero == 0) {
						System.out.println("El numero 0 en binario sigue siendo 0");
					} else if  (numero == 1) {
						System.out.println("El numero 1 en binario sigue siendo 1.");
					} else {
						System.out.println("El numero " + numero + " en binario es : " + esBinario(numero));
					}
					break;


				case 2:
					System.out.println("Pasar de numero binario a decimal");
					System.out.println("Dime un numero binario para convertir a decimal.");

					try {

						String numBinario3 = sn.nextLine().replaceAll(" ","");
						int numero2 = Integer.parseInt(numBinario3);
						int numero3 = esDecimal(numero2);

						//Comprobar si el numero es binario
						boolean numeroCorrecto = true;

						for (int i = 0; i < numBinario3.length(); i++) {
							char comprobar = numBinario3.charAt(i);
							if ( comprobar != '0' && comprobar != '1') {
								numeroCorrecto = false;
								break;
							}
						} if (!numeroCorrecto) {
							System.out.println("Error, el numero no es binario.");
							break;
						}

						System.out.println("El numero " + numBinario3 + " en decimal es : " + numero3);
					} catch (NumberFormatException e) {
						System.out.println("Error, dame un valor numérico.");
					}
					break;

				case 3:
					System.out.println("Cerrando el programa.");
					break;

				default:
					System.out.println("Error, introduce un valor entre las opciones planteadas.");
					break;
				}
			}
			catch (NumberFormatException e) {
				System.out.println("Error, dame un valor numérico");
			}
		} while (option != 3);
		sn.close();
	}

	public static String esBinario (int numero) {
		if (numero < 2) {
			return Integer.toString(numero);

		} else {
			int resto,cociente;
			resto = numero % 2;
			cociente = numero/2;
			return esBinario (cociente) + resto;
		}
	}


	public static int esDecimal(int numBinario) {
		int resultado = 0;
		int base = 1; // Inicializar la base a 2^0

		while (numBinario > 0) {
			int ultimoDigito = numBinario % 10;
			resultado += ultimoDigito * base;
			numBinario /= 10;
			base *= 2; // Multiplicar la base por 2 en cada iteración
		}
		return resultado;
	}
}