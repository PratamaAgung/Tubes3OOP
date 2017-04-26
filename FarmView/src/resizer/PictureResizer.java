package resizer;

import javax.swing.ImageIcon;

/**
 * Interface untuk mengelola ukuran gambar.
 * @author Iftitakhul Zakiah.
 */
public interface PictureResizer {
  /**
   * Implementasi methos resizePicture dari interface PictureResizer.
   * I.S : path merupakan relative path ke gambar yang ingin dimuat, height dan width
   *     adalah ukuran gambar setelah resize.
   * F.S : mengembalikan imageIcon dari gambar yang telah di-resize.
   * @param path path relative dari file gambar.
   * @param height tinggi dari gambar hasil resize.
   * @param width lebar gambar setelah resize.
   */
  public ImageIcon resizePicture(String path, int height, int width);
}
