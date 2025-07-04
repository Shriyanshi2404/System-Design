package LLD_Concepts.Solid_Principles.Liskov_Substitution_Principle.More_detail.Good_Code;

public class Main {

  public static void readAnyFile(ReadableFile file){
      file.read();
  }

  public static void main(String[] args) {
      ReadableFile readableFile = new ReadableFile();
      readableFile.read();

      WriteableFile writableFile = new WriteableFile();
      writableFile.read();
      writableFile.write();

      readAnyFile(readableFile);
      readAnyFile(writableFile);
  }
}