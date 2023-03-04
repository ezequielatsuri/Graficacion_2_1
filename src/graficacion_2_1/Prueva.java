package graficacion_2_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
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
         Shape cabeza = new Rectangle2D.Double(XcorCabeza[0], XcorCabeza[1],XcorCabeza[2], XcorCabeza[3]);
         Shape cabezaOriginal = new Rectangle2D.Double(XcorCabeza[0], XcorCabeza[1],XcorCabeza[2], XcorCabeza[3]);
	 //torzo
	 int [] XcorTorzo={120, 200,110,150};
         Shape torzo = new Rectangle2D.Double(XcorTorzo[0], XcorTorzo[1],XcorTorzo[2], XcorTorzo[3]);
         Shape torzoOriginal = new Rectangle2D.Double(XcorTorzo[0], XcorTorzo[1],XcorTorzo[2], XcorTorzo[3]);
	//brazo derecho Del muñeco no de nosostros 
	 int [] XcorBraso1 = {90, 200,30,80};
         Shape braso1 = new Rectangle2D.Double(XcorBraso1[0], XcorBraso1[1],XcorBraso1[2], XcorBraso1[3]);
         Shape braso1Original = new Rectangle2D.Double(XcorBraso1[0], XcorBraso1[1],XcorBraso1[2], XcorBraso1[3]);
	 
	 int [] XcorBraso3={95, 280,20,20};
         Shape braso3 = new Rectangle2D.Double(XcorBraso3[0], XcorBraso3[1],XcorBraso3[2], XcorBraso3[3]);
         Shape braso3Original = new Rectangle2D.Double(XcorBraso3[0], XcorBraso3[1],XcorBraso3[2], XcorBraso3[3]);
	 //brazo Izquierdo
		 int [] XcorBraso2={230, 200,30,80};
                 Shape braso2 = new Rectangle2D.Double(XcorBraso2[0], XcorBraso2[1],XcorBraso2[2], XcorBraso3[3]);
                 Shape braso2Original = new Rectangle2D.Double(XcorBraso2[0], XcorBraso2[1],XcorBraso2[2], XcorBraso2[3]);
		 int [] XcorBraso4={235, 280,20,20};
                 Shape braso4 = new Rectangle2D.Double(XcorBraso4[0], XcorBraso4[1],XcorBraso4[2], XcorBraso4[3]);
                 Shape braso4Original = new Rectangle2D.Double(XcorBraso4[0], XcorBraso4[1],XcorBraso4[2], XcorBraso4[3]);
		 //creamos dimenciones para 5 circulos para poder hacer el escalamiento y rotación 
		 //circulo superior izquierdo
		 int [] circuloRotacion1 ={90,130,30,30};
                 Shape circuloRotacion = new Ellipse2D.Double(circuloRotacion1[0], circuloRotacion1[1],circuloRotacion1[2],circuloRotacion1[3]);
                 Shape circuloRotacionOriginal = new Rectangle2D.Double(circuloRotacion1[0], circuloRotacion1[1],circuloRotacion1[2],circuloRotacion1[3]);
                 
		 int [] circuloEscalamiento1 = {260,130,30,30};
                 Shape circuloEscalamiento = new Ellipse2D.Double(circuloEscalamiento1[0],circuloEscalamiento1[1],circuloEscalamiento1[2], circuloEscalamiento1[3]);
                 Shape circuloEscalamientoOriginal = new Rectangle2D.Double(circuloEscalamiento1[0],circuloEscalamiento1[1],circuloEscalamiento1[2], circuloEscalamiento1[3]);
		 
		 int dyes;
		 int x,y; 
		 private int lastX;
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
		                    
		                    TipoDeTranformacion ="traslacion";
		                    //se establece el punto de inicio
		                    puntoArrastre = e.getPoint();
		                }
		                if (circuloEscalamiento.contains(x, y)) {
		                	
		                
		                	 TipoDeTranformacion="Escalamiento";
		                	  lastX= e.getX();
		                	 puntoArrastre = e.getPoint();
		                	 
		                }
                                if(circuloRotacion.contains(x, y)){
                                   
		                	 TipoDeTranformacion="Rotacion";
		                	 lastX= e.getX();
		                	 puntoArrastre = e.getPoint();
                                
                                }
                                
                                if(braso1.contains(x, y)){
                                             
                                             
                                             TipoDeTranformacion ="Sesgado";
                                             TipoDeSesgado = "izquierda";
                                             //se establece el punto de inicio
                                             puntoArrastre = e.getPoint();
                                }else if(braso2.contains(x, y)){
                                             
                                             
                                             TipoDeTranformacion ="Sesgado";
                                             TipoDeSesgado = "derecho";
                                             //se establece el punto de inicio
                                             puntoArrastre = e.getPoint();
                                }else if(cabeza.contains(x, y)){
                                   
                                             
                                             TipoDeTranformacion ="Sesgado";
                                             TipoDeSesgado = "arriba";
                                             //se establece el punto de inicio
                                             puntoArrastre = e.getPoint();
                                
                                }else if(pierna1.contains(x, y) || pierna2.contains(x, y)){
                                    
                                             
                                             TipoDeTranformacion ="Sesgado";
                                             TipoDeSesgado = "abajo"; 
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
                                               
                                                
                                                transform.translate(dx, dy);

                                                // Aplicamos la transformación a la figura Shape
                                                 cabeza = transform.createTransformedShape(cabezaOriginal);
                                                 torzo = transform.createTransformedShape(torzoOriginal);
                                                 braso1 = transform.createTransformedShape(braso1Original);
                                                 braso2 = transform.createTransformedShape(braso2Original);
                                                 braso3 = transform.createTransformedShape(braso3Original);
                                                 braso4 = transform.createTransformedShape(braso4Original);
                                                 pierna1 = transform.createTransformedShape(pierna1Original);
                                                 pierna2 = transform.createTransformedShape(pierna2Original);
                                                 circuloRotacion = transform.createTransformedShape(circuloRotacionOriginal);
                                                 circuloEscalamiento = transform.createTransformedShape(circuloEscalamientoOriginal);
                                                 
		            	    	 
		            	    	        puntoArrastre = e.getPoint();
		            	    	        
		            	    	        
		            	    	        repaint();
		            	    	 }else if (TipoDeTranformacion.equals("Escalamiento")) {
		            	    		
		            	    		 int x = e.getX();
		            	    		    int y = e.getY();

		            	    		    // Luego, puedes hacer una comparación para determinar si el mouse se está moviendo hacia la izquierda o hacia la derecha, por ejemplo
		            	    		    if (x > lastX) {
		            	    		        // El mouse se está moviendo hacia la derecha
		            	    		        transform.scale(1.05, 1.05); // Escalado hacia arriba
		            	    		    } else if (x < lastX) {
		            	    		        // El mouse se está moviendo hacia la izquierda
		            	    		        transform.scale(0.95, 0.95); // Escalado hacia abajo
		            	    		    }
		            	    		    lastX = x;
		            	    		 // Actualiza las formas transformadas y repinta el componente
		            	    		    pierna1 = transform.createTransformedShape(pierna1Original);
		            	    		    pierna2 = transform.createTransformedShape(pierna2Original);
		            	    		    cabeza = transform.createTransformedShape(cabezaOriginal);
		            	    		    torzo = transform.createTransformedShape(torzoOriginal);
		            	    		    braso1 = transform.createTransformedShape(braso1Original);
		            	    		    braso2 = transform.createTransformedShape(braso2Original);
		            	    		    braso3 = transform.createTransformedShape(braso3Original);
		            	    		    braso4 = transform.createTransformedShape(braso4Original);
		            	    		    circuloRotacion = transform.createTransformedShape(circuloRotacionOriginal);
		            	    		    circuloEscalamiento = transform.createTransformedShape(circuloEscalamientoOriginal);
		            	    		    repaint();
		            	    		
		            	    	 }else if (TipoDeTranformacion.equals("Sesgado")) {
                                             
                                             
                                             
                                                 if (TipoDeSesgado.equals("izquierda")) {
                                                     
                                                     transform.shear(-0.005, 0);

                                                    // Crear una figura, en este caso un rectángulo
                                                    
                                                     
                                                    // Aplicar la transformación a las figuras
                                                     pierna1 = transform.createTransformedShape(pierna1Original);
                                                     pierna2 = transform.createTransformedShape(pierna2Original);
                                                     cabeza = transform.createTransformedShape(cabezaOriginal);
                                                     torzo = transform.createTransformedShape(torzoOriginal);
                                                     braso1 = transform.createTransformedShape(braso1Original);
                                                     braso2 = transform.createTransformedShape(braso2Original);
                                                     braso3 = transform.createTransformedShape(braso3Original);
                                                     braso4 = transform.createTransformedShape(braso4Original);
                                                     circuloRotacion = transform.createTransformedShape(circuloRotacionOriginal);
                                                     circuloEscalamiento = transform.createTransformedShape(circuloEscalamientoOriginal);
  
                                                } else if(TipoDeSesgado.equals("derecho")) {
                                                    
                                                    
                                                     transform.shear(0.005, 0);
                                                     
                                                       // Aplicar la transformación a las figuras
                                                     pierna1 = transform.createTransformedShape(pierna1Original);
                                                     pierna2 = transform.createTransformedShape(pierna2Original);
                                                     cabeza = transform.createTransformedShape(cabezaOriginal);
                                                     torzo = transform.createTransformedShape(torzoOriginal);
                                                     braso1 = transform.createTransformedShape(braso1Original);
                                                     braso2 = transform.createTransformedShape(braso2Original);
                                                     braso3 = transform.createTransformedShape(braso3Original);
                                                     braso4 = transform.createTransformedShape(braso4Original);
                                                     circuloRotacion = transform.createTransformedShape(circuloRotacionOriginal);
                                                      circuloEscalamiento = transform.createTransformedShape(circuloEscalamientoOriginal);
                                                     
                                                   
                                                }else if(TipoDeSesgado.equals("arriba")){
                                                    
                                                     transform.shear(0, 0.005);
                                                     
                                                       // Aplicar la transformación a las figuras
                                                     pierna1 = transform.createTransformedShape(pierna1Original);
                                                     pierna2 = transform.createTransformedShape(pierna2Original);
                                                     cabeza = transform.createTransformedShape(cabezaOriginal);
                                                     torzo = transform.createTransformedShape(torzoOriginal);
                                                     braso1 = transform.createTransformedShape(braso1Original);
                                                     braso2 = transform.createTransformedShape(braso2Original);
                                                     braso3 = transform.createTransformedShape(braso3Original);
                                                     braso4 = transform.createTransformedShape(braso4Original);
                                                     circuloRotacion = transform.createTransformedShape(circuloRotacionOriginal);
                                                     circuloEscalamiento = transform.createTransformedShape(circuloEscalamientoOriginal);
                                                
                                                }else if(TipoDeSesgado.equals("abajo")){
                                                  
                                                     transform.shear(0, -0.005);
                                                     
                                                       // Aplicar la transformación a las figuras
                                                     pierna1 = transform.createTransformedShape(pierna1Original);
                                                     pierna2 = transform.createTransformedShape(pierna2Original);
                                                     cabeza = transform.createTransformedShape(cabezaOriginal);
                                                     torzo = transform.createTransformedShape(torzoOriginal);
                                                     braso1 = transform.createTransformedShape(braso1Original);
                                                     braso2 = transform.createTransformedShape(braso2Original);
                                                     braso3 = transform.createTransformedShape(braso3Original);
                                                     braso4 = transform.createTransformedShape(braso4Original);
                                                     circuloRotacion = transform.createTransformedShape(circuloRotacionOriginal);
                                                     circuloEscalamiento = transform.createTransformedShape(circuloEscalamientoOriginal);
                                                } 
                                                 repaint();
                                         
                                         }else if (TipoDeTranformacion.equals("Rotacion")) {
                                             //Rotacion con el metodo AffineTransform 
                                        	 int mouseX = e.getX();
                                        	 if (mouseX > lastX) {
                                                 // Mover hacia la derecha, rotar en sentido horario
                                                 transform.rotate(Math.toRadians(-1));
                                             } else if (mouseX < lastX) {
                                                 // Mover hacia la izquierda, rotar en sentido antihorario
                                                 transform.rotate(Math.toRadians(1));
                                             }

                                             lastX = mouseX;
                                             pierna1 = transform.createTransformedShape(pierna1Original);
     		            	    		    pierna2 = transform.createTransformedShape(pierna2Original);
     		            	    		    cabeza = transform.createTransformedShape(cabezaOriginal);
     		            	    		    torzo = transform.createTransformedShape(torzoOriginal);
     		            	    		    braso1 = transform.createTransformedShape(braso1Original);
     		            	    		    braso2 = transform.createTransformedShape(braso2Original);
     		            	    		    braso3 = transform.createTransformedShape(braso3Original);
     		            	    		    braso4 = transform.createTransformedShape(braso4Original);
     		            	    		    circuloRotacion = transform.createTransformedShape(circuloRotacionOriginal);
     		            	    		    circuloEscalamiento = transform.createTransformedShape(circuloEscalamientoOriginal);
     		            	    		    repaint();
                                         }
		            	    	             	   
		            }
		        });
		 }

           @Override
	        public void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        Graphics2D g2d = (Graphics2D) g;
	        
	        //cabeza
                
                    g2d.setColor(new Color(250, 227, 148));
                    g2d.fill (cabeza);
                    
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
                    
                    g2d.setColor(Color.ORANGE);
                    g2d.fill (circuloEscalamiento);
                    
                    g2d.setColor(Color.YELLOW);
                    g2d.fill (circuloRotacion);
                    
                    
                    
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

