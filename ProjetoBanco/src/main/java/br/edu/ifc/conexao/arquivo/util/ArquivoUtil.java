package br.edu.ifc.conexao.arquivo.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import org.apache.commons.io.FileUtils;
import org.postgresql.largeobject.LargeObject;
import org.postgresql.largeobject.LargeObjectManager;

public class ArquivoUtil {

    public static File carregarArquivo() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            return selectedFile;
        }
        return null;
    }

    public static Long converterArquivoEmOid(Connection conexao, File arquivo) throws Exception {
        LargeObjectManager lobj = ((org.postgresql.PGConnection) conexao).getLargeObjectAPI();
        long oid = lobj.createLO(LargeObjectManager.READ | LargeObjectManager.WRITE);
        LargeObject obj = lobj.open(oid, LargeObjectManager.WRITE);

        obj.write(ArquivoUtil.arquivoParaByte(arquivo));
        obj.close();

        return oid;
    }

    public static File converterOidEmArquivo(Blob arquivo, String nomeArquivo, String extensaoArquivo) throws Exception {
        return byteParaArquivo(arquivo.getBinaryStream(), nomeArquivo, extensaoArquivo);
    }

    private static byte[] arquivoParaByte(File arquivo) throws IOException {
        return FileUtils.readFileToByteArray(arquivo);
    }

    private static File byteParaArquivo(InputStream in, String nome, String extensao) throws Exception {
        String tmpDir = System.getProperty("java.io.tmpdir");
        File arquivo = new File(tmpDir + "/" + nome + extensao);
        FileUtils.copyInputStreamToFile(in, arquivo);
        return arquivo;
    }

}
