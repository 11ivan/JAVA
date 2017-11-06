import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

class PostRAF{
      RandomAccessFile raf;
      int largo;
      int largoci= 10; // 10 caracteres para el ci
      int largonombre= 30; // 30 para el nombre
      PostRAF(String arch) {
        try {
			this.raf= new RandomAccessFile(arch, "rw");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        this.largo= 2+this.largoci+ 2+this.largonombre;
      }
      Post leer(int nro) {
        this.raf.seek(nro*this.largo);
        String ci= trim(this.raf.readUTF());
        String nombre= trim(this.raf.readUTF());
        return new Post(ci, nombre);
      }
      void escribir(int nro, Post post) {
        this.raf.seek(nro*largo);
        this.raf.writeUTF(extender(post.ci, this.largoci));
        this.raf.writeUTF(extender(post.nombre, this.largonombre));
      }
      int tamaño() {
        return raf.length()/largo;
      }
      void close() {
        raf.close();
      }
      String extender(String s, int l) {
        return s+repeat(" ", l-length(s));
      }
    }

