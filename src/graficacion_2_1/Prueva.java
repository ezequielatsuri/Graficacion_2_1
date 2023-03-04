package bidimensional;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Prueva extends JPanel{
	
	/*
	 * Tomando encuenta que tengamos un arreglo los valores corresponden a lo siguiente:
	 * pocicion 0 = x inicial,
	 * pcocion 1 = y inicial
	 * pocicion 2 = ancho
	 * pocicion 3 = largo
	 * */
    
         //banaderas
           boolean sesgado = false;
           boolean otro = true;
	//pierna derecha
	 int [] XcorPier1={135, 350,30,100};
         Shape pierna1 = new Rectangle2D.Double(XcorPier1[0], XcorPier1[1],XcorPier1[2], XcorPier1[3]);
         Shape pierna1Original = new Rectangle2D.Double(XcorPier1[0], XcorPier1[1],XcorPier1[2], XcorPier1[3]);
	//pierna izquierda
        int [] XcorPier2={185, 350,30,100};
         Shape pierna2 = new Rectangle2D.Double(XcorPier2[0], XcorPier2[1],XcorPier2[2], XcorPier2[3]);
         Shape pierna2Original = new Rectangle2D.Double(XcorPier2[0], XcorPier2[1],XcorPier2[2], XcorPier2[3]);
	 //cabeza
	 int [] XcorCabeza={150, 150,50,50};
        // Rectangle cabeza = new Rectangle(XcorCabeza[0], XcorCabeza[1],XcorCabeza[2], XcorCabeza[3]);
         Shape rectangle = new Rectangle2D.Double(XcorCabeza[0], XcorCabeza[1],XcorCabeza[2], XcorCabeza[3]);
         Shape CabezaOriginal = new Rectangle2D.Double(XcorCabeza[0], XcorCabeza[1],XcorCabeza[2], XcorCabeza[3]);
	 //torzo
	 int [] XcorTorzo={120, 200,110,150};
         Shape torzo = new Rectangle2D.Double(XcorTorzo[0], XcorTorzo[1],XcorTorzo[2], XcorTorzo[3]);
         Shape torzoOriginal = new Rectangle2D.Double(XcorTorzo[0], XcorTorzo[1],XcorTorzo[2], XcorTorzo[3]);
	//brazo derecho Del muñeco no de nosostros 
	 int [] XcorBraso1 = {90, 200,30,80};
         Shape braso1 = new Rectangle2D.Double(XcorBraso1[0], XcorBraso1[1],XcorBraso1[2], XcorBraso1[3]);
         Shape braso1Orignal = new Rectangle2D.Double(XcorBraso1[0], XcorBraso1[1],XcorBraso1[2], XcorBraso1[3]);
	 
	 int [] XcorBraso3={95, 280,20,20};
         Shape braso3 = new Rectangle2D.Double(XcorBraso3[0], XcorBraso3[1],XcorBraso3[2], XcorBraso3[3]);
         Shape braso3Orignal = new Rectangle2D.Double(XcorBraso3[0], XcorBraso3[1],XcorBraso3[2], XcorBraso3[3]);
	 //brazo Izquierdo
		 int [] XcorBraso2={230, 200,30,80};
                 Shape braso2 = new Rectangle2D.Double(XcorBraso2[0], XcorBraso2[1],XcorBraso2[2], XcorBraso3[3]);
                 Shape braso2Orignal = new Rectangle2D.Double(XcorBraso2[0], XcorBraso2[1],XcorBraso2[2], XcorBraso2[3]);
		 int [] XcorBraso4={235, 280,20,20};
                 Shape braso4 = new Rectangle2D.Double(XcorBraso4[0], XcorBraso4[1],XcorBraso4[2], XcorBraso4[3]);
                 Shape braso4Orignal = new Rectangle2D.Double(XcorBraso4[0], XcorBraso4[1],XcorBraso4[2], XcorBraso4[3]);
		 //creamos dimenciones para 5 circulos para poder hacer el escalamiento y rotación 
		 //circulo superior izquierdo
		 int [] Circulo={90,130,10,10};
		 int [] Circulo2={260,130,10,10};
		 int [] Circulo3={260,460,10,10};
		 int [] Circulo4={90,460,10,10};
		 int dyes;
		 int x,y; 
		 double factorEscala=1.0;
		 String TipoDeTranformacion="null";
                 String TipoDeSesgado = "null";
		 private Point puntoArrastre;
                 // Creamos una instancia de la clase AffineTransform
               // Crear una instancia de AffineTransform
AffineTransform transform = new AffineTransform();

// Aplicar una transformación de sesgo

                 
		 public Prueva() {
			 
			 addMouseListener(new MouseAdapter() {
		            @Override
		            public void mousePressed(MouseEvent e) {
		                x=e.getX();
		                y=e.getY();
		                //creamos 4 condiciones para saber donde se encuentra el cursor y apartir de eso sabemos que vamos hacer
		                //esta condicion verifica que este en el area del torzo para hacer la rotación 
                                //x >= XcorTorzo[0] && x <= XcorTorzo[0] + XcorTorzo[2] && y >= XcorTorzo[1] && y <= XcorTorzo[1] + XcorTorzo[3]
		                if (torzo.contains(x, y)) {
		                    System.out.println("El cursor está pulsando el torso");
		                    TipoDeTranformacion ="traslacion";
                                    sesgado = false;
                                    otro = true;
		                    //se establece el punto de inicio
		                    puntoArrastre = e.getPoint();
		                }
		                if ((x >= Circulo[0] && x <= Circulo[0] + Circulo[2] && y >= Circulo[1] && y <= Circulo[1] + Circulo[3]) ||
		                        (x >= Circulo2[0] && x <= Circulo2[0] + Circulo2[2] && y >= Circulo2[1] && y <= Circulo2[1] + Circulo2[3]) ||
		                        (x >= Circulo3[0] && x <= Circulo3[0] + Circulo3[2] && y >= Circulo3[1] && y <= Circulo3[1] + Circulo3[3]) ||
		                        (x >= Circulo4[0] && x <= Circulo4[0] + Circulo4[2] && y >= Circulo4[1] && y <= Circulo4[1] + Circulo4[3])) {
		                	
		                	System.out.println("El cursor está dentro de un círculo");
		                	 TipoDeTranformacion="Escalamiento";
                                         sesgado = false;
                                         otro = true;
		                	 puntoArrastre = e.getPoint();
		                	 dyes = e.getY()-Circulo3[1];
		                }if((x >= XcorBraso1[0] && x <= XcorBraso1[0] + XcorBraso1[2] && y >= XcorBraso1[1] && y <= XcorBraso1[1] + XcorBraso1[3])){
                                             System.out.println("El cursor está pulsando el braso izquierdo");
                                             pierna1 = pierna1Original;
                                             pierna2 = pierna2Original;
                                             rectangle = CabezaOriginal;
                                             torzo = torzoOriginal;
                                             braso1 = braso1Orignal;
                                             braso2 = braso2Orignal;
                                             braso3 = braso3Orignal;
                                             braso4 = braso4Orignal;
                                             TipoDeTranformacion ="Sesgado";
                                             sesgado = true;
                                             otro = false;
                                             TipoDeSesgado = "izquierda";
                                             //se establece el punto de inicio
                                             puntoArrastre = e.getPoint();
                                }else if((x >= XcorBraso2[0] && x <= XcorBraso2[0] + XcorBraso2[2] && y >= XcorBraso2[1] && y <= XcorBraso2[1] + XcorBraso2[3])){
                                             System.out.println("El cursor está pulsando el braso derecho");
                                             pierna1 = pierna1Original;
                                             pierna2 = pierna2Original;
                                             rectangle = CabezaOriginal;
                                             torzo = torzoOriginal;
                                             braso1 = braso1Orignal;
                                             braso2 = braso2Orignal;
                                             braso3 = braso3Orignal;
                                             braso4 = braso4Orignal;
                                             sesgado = true;
                                             otro = false;
                                             TipoDeTranformacion ="Sesgado";
                                             TipoDeSesgado = "derecho";
                                             //se establece el punto de inicio
                                             puntoArrastre = e.getPoint();
                                }   
		            }
		            @Override
		            public void mouseReleased(MouseEvent e) {
		                // Al soltar el mouse, limpiamos el punto de arrastre
		            	puntoArrastre = null;
		            }
		        });
			 addMouseMotionListener(new MouseAdapter() {
		            @Override
		            public void mouseDragged(MouseEvent e) {
		            	if (puntoArrastre == null) {
		            	    return;
		            	}
		            	    	 if (TipoDeTranformacion.equals("traslacion")) {
		            	    		int dx = e.getX() - puntoArrastre.x;
		            	    	        int dy = e.getY() - puntoArrastre.y;
                                                
                                                
                                                
		            	    	        // Actualizamos las coordenadas del torso sumando el desplazamiento
		            	    	        XcorTorzo[0] += dx;
		            	    	        XcorTorzo[1] += dy;
		            	    	        XcorCabeza[0]+=dx;
		            	    	        XcorCabeza[1]+=dy;
		            	    	        XcorPier1[0] +=dx;
		            	    	        XcorPier2[0] +=dx;
		            	    	        XcorBraso1[0] +=dx;
		            	    	        XcorBraso3[0] +=dx;
		            	    	        XcorBraso2[0] +=dx;
		            	    	        XcorBraso4[0] +=dx;
		            	    	        XcorPier1[1] +=dy;
		            	    	        XcorPier2[1]  +=dy;
		            	    	        XcorBraso1[1] +=dy;
		            	    	        XcorBraso3[1]+=dy;
		            	    	        XcorBraso2[1]+=dy;
		            	    	        XcorBraso4[1]+=dy;
		            	    	        Circulo[1]+=dy;
		            	    	        Circulo[0]+=dx;
		            	    	        Circulo2[1]+=dy;
		            	    	        Circulo2[0]+=dx;
		            	    	        Circulo3[0]+=dx;
		            	    	        Circulo4[1]+=dy;
		            	    	        Circulo4[0]+=dx;
                                                    //se aplica el cambio de la figura para las nuevas trasformaciones
                                                pierna1Original = new Rectangle2D.Double(XcorPier1[0], XcorPier1[1],XcorPier1[2], XcorPier1[3]);
                                                pierna2Original = new Rectangle2D.Double(XcorPier2[0], XcorPier2[1],XcorPier2[2], XcorPier2[3]);
                                                CabezaOriginal = new Rectangle2D.Double(XcorCabeza[0], XcorCabeza[1],XcorCabeza[2], XcorCabeza[3]);
                                                torzoOriginal = new Rectangle2D.Double(XcorTorzo[0], XcorTorzo[1],XcorTorzo[2], XcorTorzo[3]);
                                                braso1Orignal = new Rectangle2D.Double(XcorBraso1[0], XcorBraso1[1],XcorBraso1[2], XcorBraso1[3]);
                                                braso3Orignal = new Rectangle2D.Double(XcorBraso3[0], XcorBraso3[1],XcorBraso3[2], XcorBraso3[3]);
                                                braso2Orignal = new Rectangle2D.Double(XcorBraso2[0], XcorBraso2[1],XcorBraso2[2], XcorBraso2[3]);
                                                braso4Orignal = new Rectangle2D.Double(XcorBraso4[0], XcorBraso4[1],XcorBraso4[2], XcorBraso4[3]);
		            	    	        // Actualizamos el punto de arrastre
		            	    	        puntoArrastre = e.getPoint();
		            	    	        
		            	    	        
		            	    	        repaint();
		            	    	 }else if (TipoDeTranformacion.equals("Escalamiento")) {
		            	    		int dx = e.getX() - puntoArrastre.x;
		            	    	        int dy = e.getY() - puntoArrastre.y;
		            	    		 int dye = e.getY()-Circulo3[1];
		            	    		 if(x >= Circulo3[0] && x <= Circulo3[0] + Circulo3[2] && y >= Circulo3[1] && y <= Circulo3[1] + Circulo3[3]) {
		            	    			if (dye > dyes ) {
		            	    				
		            	    				XcorTorzo[2] = (int)(XcorTorzo[2] +1);
		            	    				XcorTorzo[3] = (int)(XcorTorzo[3] +1);
		            	    				Circulo[1]+=dy;
			            	    	        Circulo[0]+=dx;
			            	    	        Circulo2[1]+=dy;
			            	    	        Circulo2[0]+=dx;
			            	    	        Circulo3[0]+=dx;
			            	    	        Circulo4[1]+=dy;
			            	    	        Circulo4[0]+=dx;
		            	    				repaint();
		            	    			}else {
		            	    				XcorTorzo[2] = (int)(XcorTorzo[2] +1);
		            	    				XcorTorzo[3] = (int)(XcorTorzo[3] +1);
		            	    				Circulo[1]+=dy;
			            	    	      
		            	    				repaint();
		            	    				
		            	    			}
		            	    			
		            	    			 
		            	    			 
		            	    		 }
		            	    		 
		            	    		 
		            	    		
		            	    	 }else if (TipoDeTranformacion.equals("Sesgado")) {
                                             
                                             System.out.println("entro al sesgado");
                                             
                                                 if (TipoDeSesgado.equals("izquierda")) {
                                                     System.out.println("entro aqui a la izquierda");
                                                     transform.shear(-0.000009, 0);

                                                    // Crear una figura, en este caso un rectángulo
                                                    
                                                     
                                                    // Aplicar la transformación a las figuras
                                                     pierna1 = transform.createTransformedShape(pierna1);
                                                     pierna2 = transform.createTransformedShape(pierna2);
                                                     rectangle = transform.createTransformedShape(rectangle);
                                                     torzo = transform.createTransformedShape(torzo);
                                                     braso1 = transform.createTransformedShape(braso1);
                                                     braso2 = transform.createTransformedShape(braso2);
                                                     braso3 = transform.createTransformedShape(braso3);
                                                     braso4 = transform.createTransformedShape(braso4);
  
                                                } 
                                                 if(TipoDeSesgado.equals("derecho")) {
                                                    
                                                     System.out.println("entro aqui a la derecha");
                                                     transform.shear(0.000009, 0);
                                                     
                                                      pierna1 = transform.createTransformedShape(pierna1);
                                                     pierna2 = transform.createTransformedShape(pierna2);
                                                     rectangle = transform.createTransformedShape(rectangle);
                                                     torzo = transform.createTransformedShape(torzo);
                                                     braso1 = transform.createTransformedShape(braso1);
                                                     braso2 = transform.createTransformedShape(braso2);
                                                     braso3 = transform.createTransformedShape(braso3);
                                                     braso4 = transform.createTransformedShape(braso4);
                                                     
                                                     
                                                     
                                                    //xCoords[0] += dx-xCoords[0];
                                                    //xCoords[1] += (dx-xCoords[1])+100;
                                                    
                                                }
                                                 repaint();
                                         
                                         }
		            	    	             	    
		            	  
		            	   
		            	  
		            	  
		            	 //  repaint();
		            	    
		                  

		            }
		        });
		 }

			 public void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        Graphics2D g2d = (Graphics2D) g;
	        
	        //cabeza
                if(sesgado == true){
                    g2d.setColor(new Color(250, 227, 148));
                    g2d.fill (rectangle);
                    
                    g2d.setColor(new Color(75, 238, 4));
                    g2d.fill (torzo);
                    
                    g2d.setColor(new Color(112, 249, 52));
                    g2d.fill (braso1);
                    
                    g2d.setColor(new Color(250, 227, 148));
                    g2d.fill (braso3);
                    
                    g2d.setColor(new Color(112, 249, 52));
                    g2d.fill (braso2);
                    
                    g2d.setColor(new Color(250, 227, 148));
                    g2d.fill (braso4);
                    
                    g2d.setColor(Color.RED);
                    g2d.fill (pierna1);
                    
                    g2d.setColor(Color.RED);
                    g2d.fill (pierna2);
                    
                    
                    
                    
                }else if(otro == true){
                   //cabeza 
                    g2d.setColor(new Color(250, 227, 148));
                    g2d.fillRect (XcorCabeza[0], XcorCabeza[1], XcorCabeza[2], XcorCabeza[3]);
                    //torzo
	        g2d.setColor(new Color(75, 238, 4));
	        g2d.fillRect (XcorTorzo[0], XcorTorzo[1], XcorTorzo[2], XcorTorzo[3]);
	        
	        //brazo derecho
	        g2d.setColor(new Color(112, 249, 52));
	        g2d.fillRect (XcorBraso1[0], XcorBraso1[1], XcorBraso1[2], XcorBraso1[3]);
	        
	        g2d.setColor(new Color(250, 227, 148));
	        g2d.fillRect (XcorBraso3[0], XcorBraso3[1], XcorBraso3[2], XcorBraso3[3]);
	        
	        
	      //brazo Izquierdo
	        g2d.setColor(new Color(112, 249, 52));
	        g2d.fillRect (XcorBraso2[0], XcorBraso2[1], XcorBraso2[2], XcorBraso2[3]);
	        g2d.setColor(new Color(250, 227, 148));
	        g2d.fillRect (XcorBraso4[0], XcorBraso4[1], XcorBraso4[2], XcorBraso4[3]);
	        
	        g2d.setColor(Color.RED);
	        // Dibujar un rectángulo vertical
	        g2d.fillRect (XcorPier1[0], XcorPier1[1], XcorPier1[2], XcorPier1[3]);
	        
	        g2d.setColor(Color.RED);
	        // Dibujar un rectángulo vertical
	        g2d.fillRect (XcorPier2[0], XcorPier2[1], XcorPier2[2], XcorPier2[3]);
	        
	        //circulo superior derecho
	        g2d.setColor(Color.black);
	        g2d.fillOval (Circulo[0], Circulo[1], Circulo[2], Circulo[3]);
	        g2d.setColor(Color.black);
	        g2d.fillOval (Circulo2[0], Circulo2[1], Circulo2[2], Circulo2[3]);
	        g2d.setColor(Color.black);
	        g2d.fillOval (Circulo3[0], Circulo3[1], Circulo3[2], Circulo3[3]);
	        g2d.setColor(Color.black);
	        g2d.fillOval (Circulo4[0], Circulo4[1], Circulo4[2], Circulo4[3]);
                
                
                }
                
	        
	        
	        
	    }	 

	    public static void main(String[] args) {
	        JFrame frame = new JFrame("Mariposa");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        Prueva mariposa = new Prueva();
	        frame.add(mariposa);
	        frame.setSize(1000, 600);
	        frame.setVisible(true);
	    }
	

}
