/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utility;

import com.entity.Hadrdness;
import com.entity.Importance;
import com.entity.Question;
import com.entity.SubChapter;
import com.entity.User;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 *
 * @author ryan
 */
public class XlsParser {

    public static List<Question> doPars(String file) {
        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;
            HSSFCell cell;
            List<Question> qList = new ArrayList<>();
            String user = null, chapter;

            int rows; // No of rows
            rows = sheet.getPhysicalNumberOfRows();

            int cols = 0; // No of columns
            int tmp = 0;

            // This trick ensures that we get the data properly even if it doesn't start from first few rows
            for (int i = 0; i < 10 || i < rows; i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                    if (tmp > cols) {
                        cols = tmp;
                    }
                }
            }

            for (int r = 0; r < rows; r++) {
                System.out.println("row " + r);
                row = sheet.getRow(r);
                if (row != null) {
                    for (int c = 0; c < cols; c++) {
                        cell = row.getCell((short) c);
                        if (cell != null) {
                            if (r == 0) {
                                if (c == 0) {
                                    System.out.println("user = " + cell);
                                    user = cell.toString();
                                }
                                if (c == 1) {
                                    System.out.println("chapter = " + cell);
                                    chapter = cell.toString();
                                }
                            }
                            if (r > 0) {
                                Question ou = new Question();
                                switch (c) {
                                    case 0:
                                        System.out.println("subchapter = " + cell);
                                        ou.setSubChapterId(new SubChapter(Integer.parseInt(cell.toString())));
                                        break;
                                    case 1:
                                        System.out.println("soal = " + cell);
                                        ou.setQuestion(cell.toString());
                                        break;
                                    case 2:
                                        System.out.println("javab1 = " + cell);
                                        ou.setAnswerA(cell.toString());
                                        break;
                                    case 3:
                                        System.out.println("javab2 = " + cell);
                                        ou.setAnswerB(cell.toString());
                                        break;
                                    case 4:
                                        System.out.println("javab3 = " + cell);
                                        ou.setAnswerC(cell.toString());
                                        break;
                                    case 5:
                                        System.out.println("javab4 = " + cell);
                                        ou.setAnswerD(cell.toString());
                                        break;
                                    case 6:
                                        System.out.println("javabe dorost = " + cell);
                                        ou.setAnswer(Integer.parseInt(cell.toString()));
                                        break;
                                    case 7:
                                        System.out.println("description = " + cell);
                                        ou.setDescription(cell.toString());
                                        break;
                                    case 8:
                                        System.out.println("note = " + cell);
                                        ou.setNote(cell.toString());
                                        break;
                                    case 9:
                                        System.out.println("time = " + cell);
                                        ou.setTime(Integer.parseInt(cell.toString()));
                                        break;
                                    case 10:
                                        System.out.println("hardness = " + cell);
                                        ou.setHadrdnessId(new Hadrdness(Integer.parseInt(cell.toString())));
                                        break;
                                    case 11:
                                        System.out.println("importance = " + cell);
                                        ou.setImportanceId(new Importance(Integer.parseInt(cell.toString())));
                                        break;

                                }
                                ou.setUserId(new User(Integer.parseInt(user)));
                                qList.add(ou);
                            }

                        }
                    }
                }
            }
            return qList;
        } catch (Exception ioe) {
            ioe.printStackTrace();
            return null;
        }
    }

}
