/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utility;

import com.entity.Category;
import com.entity.Chapter;
import com.entity.Course;
import com.entity.GlobalStatus;
import com.entity.Hadrdness;
import com.entity.Importance;
import com.entity.Lesson;
import com.entity.Question;
import com.entity.QuestionType;
import com.entity.SubChapter;
import com.entity.User;
import com.service.CategoryService;
import com.service.CategoryServiceImp;
import com.service.ChapterService;
import com.service.ChapterServiceImp;
import com.service.CourseService;
import com.service.CourseServiceImp;
import com.service.LessonService;
import com.service.LessonServiceImp;
import com.service.SubChapterService;
import com.service.SubChapterServiceImp;
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
        int subchapter, importance = 1, userid, hardness = 1, time, answer, qType;
        int categoryId = 0;
        int LessonId = 0;
        int courseId = 0;
        int chapterID = 0;
        int subChapterID = 0;
        int level = 0;
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
            Question ou = new Question();
            boolean flag = false;
            for (int r = 0; r < rows; r++) {
                System.out.println("row " + r);
                ou = new Question();
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
                                if (c == 2) {
                                    System.out.println("importance = " + cell);
                                    importance = (int) Double.parseDouble(cell.toString());
                                }

                                if (c == 4) {
                                    System.out.println("qType = " + cell);
                                    qType = (int) Double.parseDouble(cell.toString());
                                }
                                //
                                if (c == 5) {
                                    CategoryService categoryService = new CategoryServiceImp();
                                    Category category = new Category();
                                    category.setName(cell.toString());
                                    category.setDescription(cell.toString());
                                    categoryId = categoryService.saveCategoryRetriveId(category);
                                    System.out.println("Lesson Group ID ======== " + categoryId);
                                }
                                if (c == 6) {
                                    System.out.println("Course = " + cell);
                                    CourseService courseService = new CourseServiceImp();
                                    Course course = new Course();
                                    course.setName(cell.toString());
                                    course.setDescription(cell.toString());
                                    course.setCategoryId(new Category(categoryId));
                                    courseId = courseService.saveCourseRetriveID(course);
                                    System.out.println("Course ID ======== " + courseId);
                                    //  qType = (int) Double.parseDouble(cell.toString());
                                }
                                if (c == 7) {

                                    // qType = (int) Double.parseDouble(cell.toString());
                                    System.out.println("sub Course = " + cell);
                                    LessonService lessonService = new LessonServiceImp();
                                    Lesson lesson = new Lesson();
                                    lesson.setCourseId(new Course(courseId));
                                    lesson.setDescription(cell.toString());
                                    lesson.setName(cell.toString());
                                    LessonId = lessonService.saveLessonRetrive(lesson);
                                    System.out.println("sub Course ID ======== " + LessonId);
                                }

                            }

                            if (r > 0) {

                                switch (c) {
                                    case 0:
                                        
                                        try {
                                            level = Integer.parseInt(cell.toString());
                                            System.out.println("level = " + cell);
                                        } catch (Exception e) {
                                            System.out.println("level -- = " + cell);
                                        }
                                        break;
                                    case 1:
                                        if (cell.toString().equals("-") || cell.toString() == null) {

                                        } else {
                                            ChapterService chapterService = new ChapterServiceImp();
                                            Chapter chapte = new Chapter();
                                            chapte.setDescription(cell.toString());
                                            chapte.setName(cell.toString());
                                            chapte.setLessonId(new Lesson(LessonId));
                                            chapterID = chapterService.saveChapterRetriveID(chapte);

                                        }
                                        System.out.println("Chapter = " + cell);
                                        System.out.println("chapterID = " + chapterID);
                                        // ou.setSubChapterId(new SubChapter((int) Double.parseDouble(cell.toString())));
                                        break;
                                    case 2:
                                        if (cell.toString().equals("-") || cell.toString() == null) {

                                        } else {
                                            SubChapterService chapterService = new SubChapterServiceImp();
                                            SubChapter subChapter = new SubChapter();
                                            subChapter.setDescription(cell.toString());
                                            subChapter.setName(cell.toString());
                                            subChapter.setChapterId(new Chapter(chapterID));
                                            subChapter.setSequence(level);
                                            subChapterID = chapterService.saveSubChapterRetriveID(subChapter);
                                            // subChapterID =  chapterService.saveSubChapterRetriveID(chapterService);
                                        }
                                        System.out.println("subChapterID = " + subChapterID);
                                        System.out.println("sub-Chapter = " + cell);
                                        // ou.setSubChapterId(new SubChapter((int) Double.parseDouble(cell.toString())));
                                        break;
                                    case 3:
                                        System.out.println("soal = " + cell);
                                        ou.setQuestion(cell.toString());
                                        break;
                                    case 4:
                                        System.out.println("javab1 = " + cell);
                                        ou.setAnswerA(cell.toString());
                                        break;
                                    case 5:
                                        System.out.println("javab2 = " + cell);
                                        ou.setAnswerB(cell.toString());
                                        break;
                                    case 6:
                                        System.out.println("javab3 = " + cell);
                                        ou.setAnswerC(cell.toString());
                                        break;
                                    case 7:
                                        System.out.println("javab4 = " + cell);
                                        ou.setAnswerD(cell.toString());
                                        break;
                                    case 8:
                                        try {
                                            answer = (int) Double.parseDouble(cell.toString());
                                            ou.setAnswer(answer);
                                            System.out.println("javabe dorost = " + answer);
                                        } catch (Exception e) {
                                        }
                                        break;
                                    case 9:
                                        System.out.println("description = " + cell);
                                        ou.setDescription(cell.toString());
                                        break;
                                    case 10:
                                        System.out.println("note = " + cell);
                                        ou.setNote(cell.toString());
                                        break;
                                    case 11:
                                        try {
                                            time = (int) Double.parseDouble(cell.toString());
                                            ou.setTime(time);
                                            System.out.println("time = " + time);
                                        } catch (Exception e) {
                                        }

                                        break;
                                    case 12:
                                        try {
                                            hardness = (int) Double.parseDouble(cell.toString());
                                            System.out.println("hardness = " + hardness);
                                        } catch (Exception e) {
                                        }
                                        break;
                                    case 13:
                                        try {
                                            importance = (int) Double.parseDouble(cell.toString());
                                            System.out.println("importance = " + importance);
                                        } catch (Exception e) {
                                        }
                                        break;

                                }

                            }

                        }
                    }
                }
                if (flag) {
                    ou.setUserId(new User((int) Double.parseDouble(user)));
                    ou.setHadrdnessId(new Hadrdness(hardness));
                    ou.setImportanceId(new Importance(importance));
                    ou.setQuestionTypeId(new QuestionType(1));
                    ou.setGlobalStatusId(new GlobalStatus(1));
                    ou.setSubChapterId(new SubChapter(subChapterID));
                    qList.add(ou);
                }
                flag = true;
            }
            return qList;
        } catch (Exception ioe) {
            ioe.printStackTrace();
            return null;
        }
    }

}
