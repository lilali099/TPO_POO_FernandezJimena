package Persistencia;

import Organizacion.JuegoOlimpico;

import java.io.*;

public class GestorPersistencia {
    public static void guardar(JuegoOlimpico jo) {

            try {
                ObjectOutputStream oos =
                        new ObjectOutputStream(new FileOutputStream("juegos.dat"));

                oos.writeObject(jo);
                oos.close();
                System.out.println("Datos guardados correctamente.");

            } catch (IOException e) {
                System.out.println("Error al guardar: " + e.getMessage());
            }
        }

        public static JuegoOlimpico cargar() {

            try {
                ObjectInputStream ois =
                        new ObjectInputStream(new FileInputStream("juegos.dat"));
                JuegoOlimpico jo = (JuegoOlimpico) ois.readObject();
                ois.close();
                return jo;

            } catch (Exception e) {
                return null;
            }
        }
    }

