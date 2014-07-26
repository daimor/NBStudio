/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nbstudio.cachefilesystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileView;

/**
 *
 * @author daimor
 */
public class CacheFileView extends FileView {

    final static int fileIconWidth = 16;
    final static int fileIconHeight = 16;
    final static int countFilesIcons = 17;
    final Icon[] filesIcons = new ImageIcon[countFilesIcons];
    final static int FILE_ICON_INDEX_CONN = 2;
    final static int FILE_ICON_INDEX_INC = 3;
    final static int FILE_ICON_INDEX_INT = 4;
    final static int FILE_ICON_INDEX_MAC = 5;
    final static int FILE_ICON_INDEX_CLS = 7;
    final static int FILE_ICON_INDEX_PKG = 10;
    final static int FILE_ICON_INDEX_PRJ = 11;
    final static int FILE_ICON_INDEX_BAS = 12;
    final static Map<String, Integer> fileTypesIcon = new HashMap<>();

    {
        try {
            fileTypesIcon.put("INC", FILE_ICON_INDEX_INC);
            fileTypesIcon.put("INT", FILE_ICON_INDEX_INT);
            fileTypesIcon.put("MAC", FILE_ICON_INDEX_MAC);
            fileTypesIcon.put("CLS", FILE_ICON_INDEX_CLS);
            fileTypesIcon.put("PKG", FILE_ICON_INDEX_PKG);
            fileTypesIcon.put("PRJ", FILE_ICON_INDEX_PRJ);
            fileTypesIcon.put("BAS", FILE_ICON_INDEX_BAS);

            ImageFilter filter = new RGBImageFilter() {
                int transparentColor = Color.white.getRGB() | 0xFF000000;

                @Override
                public final int filterRGB(int x, int y, int rgb) {
                    if ((x == 0) && (y == 0)) {
                        transparentColor = rgb;
                    }
                    if ((rgb | 0xFF000000) == transparentColor) {
                        return 0x00FFFFFF & rgb;
                    } else {
                        return rgb;
                    }
                }
            };
            BufferedImage bi = ImageIO.read(getClass().getResource("/resources/files.bmp"));
            ImageProducer filteredImgProd = new FilteredImageSource(bi.getSource(), filter);
            Image transparentImg = Toolkit.getDefaultToolkit().createImage(filteredImgProd);
            BufferedImage transparentBufImg = new BufferedImage(transparentImg.getWidth(null), transparentImg.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            transparentBufImg.getGraphics().drawImage(transparentImg, 0, 0, null);

            for (int i = 0; i < countFilesIcons; i++) {
                filesIcons[i] = new ImageIcon(transparentBufImg.getSubimage(fileIconWidth * i, 0, fileIconWidth, fileIconHeight));
            }
        } catch (IOException ex) {
        }
    }

    @Override
    public Icon getIcon(File f) {
        if (f instanceof CacheRootFile) {
            String fileName = f.getAbsolutePath();
            fileName = fileName.replaceAll("^.*\\/(.*)$", "$1");
            String fileExt = fileName.replaceAll("^.*\\.(.*)$", "$1").toUpperCase();
            if (fileName.isEmpty()) {
                return filesIcons[FILE_ICON_INDEX_CONN];
            } else if (fileTypesIcon.containsKey(fileExt)) {
                return filesIcons[fileTypesIcon.get(fileExt)];
            } else {
                return filesIcons[0];
            }
        }
        return super.getIcon(f);
    }
}
