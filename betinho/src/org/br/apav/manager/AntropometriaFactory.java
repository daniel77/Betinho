package org.br.apav.manager;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.br.apav.framework.Pesquisa;
import org.br.apav.model.Antropometria;
import org.br.apav.model.Crianca;

public class AntropometriaFactory {

    public static AntropometriaFactory instancia(int codCrianca) {

	if (antropometriaFactory == null) {
	    antropometriaFactory = new AntropometriaFactory();
	}
	 antropometriaFactory.crianca = Pesquisa.carregar(Crianca.class,codCrianca);
	return antropometriaFactory;

    }

    private AntropometriaFactory() {

    }

    static AntropometriaFactory antropometriaFactory;

    Crianca crianca;

    ArrayList<Byte> conteudo = new ArrayList<Byte>();

    File arquivo;

    public void carregarArquivo(PrintWriter out) {

	String nomeArquivo = "";
	nomeArquivo = crianca.getNome();
	arquivo = new File("", new Date() + nomeArquivo + "_antropometria.cvs");

	try {

	    List<Antropometria> ant = crianca.getAntropometrias();

	    for (Antropometria antropometria : ant) {
		double imc = Double.valueOf(antropometria.getPeso())
			/ Math.pow(Double.valueOf(antropometria.getAltura()), 2);
		imc=imc*10;
		Date datanasc = crianca.getDataNascimento();
		Date datadele = antropometria.getData();

		Calendar cal = Calendar.getInstance();
		cal.setTime(datanasc);

		Calendar cal_hj = Calendar.getInstance();
		cal_hj.setTime(datadele);

		int idade = cal_hj.get(Calendar.YEAR) - cal.get(Calendar.YEAR);

		String b = new String(imc + "," + idade + ","
			+ crianca.getCodCrianca() + "," + crianca.getNome()
			+ "\n");

		out.write(b);

	    }
	    out.close();

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    /*
     public String publicarArquivo(){
     try{
     
     String nomeDestino = "";
     //File destino = new File(nomeDestino);
     boolean fonteBoolean = arquivo.exists(); 
     boolean destinoBoolean = true; //destino.exists();
     if( fonteBoolean && !destinoBoolean){
     FileInputStream in = new FileInputStream(arquivo.getName());
     // = new FileOutputStream(nomeDestino);
     byte[] buffer = new byte[8736]; //tamanho do arquivo!
     int length = in.read(buffer);
     while(length != -1){ //sinaliza EOF end of file
     out.print(buffer);
     //write(buffer,0,length);
     in.read(buffer);
     length = in.read(buffer);
     }
     in.close();
     out.flush();
     out.close();
     }
     return nomeDestino;
     }catch(IOException e){
     e.printStackTrace();
     }
     return null;
     
     }
     */
}
