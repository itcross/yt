package com.cross.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.security.auth.Subject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cross.model.User;
import com.cross.service.UserDaoImpl;
import com.cross.util.Test;
import com.cross.util.Validation;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.googleapis.media.MediaHttpUploaderProgressListener;
import com.google.api.client.http.InputStreamContent;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoSnippet;
import com.google.api.services.youtube.model.VideoStatus;
import com.google.common.collect.Lists;

@Controller
public class UserController {
	
	@Autowired
	private UserDaoImpl userDao;
	private static YouTube youtube;
  /* Global instance of the format used for the video being uploaded (MIME type). */
	private static String VIDEO_FILE_FORMAT = "video/*";
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	//Auth a = new Auth();
	
	//유투브 업로드 시, 제목과 내용 및 태그 설정
	String subject = "";
	String description = "";
	
	@RequestMapping(value = "/ytset", method = RequestMethod.GET)   //POST로 변경요망
	public String youtubeOption(){
		//post로  mp3파일명과 png파일명을 받아야함
		return "set";
		
	}
	

	@RequestMapping(value = "/pp", method = RequestMethod.POST)   //POST로 변경요망
	public String youtubeOption(@RequestParam String title, @RequestParam String desc, @RequestParam String[] tag){
		subject = title;
		System.out.println(desc);
		System.out.println(tag[0]);
		
		return "write";
		
	}
	

	//업로드버튼 클릭시 파일변환 로딩중(css) 페이지
	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public String l(/*@RequestParam String mp3, @RequestParam String img*/Model model){
		//get으로 mp3파일명과 png파일명을 받아야함
		String mp3 = "test.mp3";
		String img = "test.png";
		model.addAttribute("mp3", mp3);
		model.addAttribute("img", img);
		System.out.println(subject);
		//process 구동
		return "test"; //로딩화면
	}
	

	//파일 변환 프로세스 실행
	@RequestMapping(value = "/t", method= RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> a1(@RequestParam String mp3Name, @RequestParam String imgName){
		System.out.println(mp3Name);
		System.out.println(imgName);
		Map<String, Object> r = new Test().returnedUrl();
		//파일네임을 돌려받음
		//유투브 업로드 메소드
		
		// Scope required to upload to YouTube.
	    List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube.upload");

	    try {
	      // Authorization.
	      Credential credential = Auth.authorize(scopes);

	      // YouTube object used to make all API requests.
	      youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, credential).setApplicationName(
	          "youtube-cmdline-uploadvideo-sample").build();
	      
	      // We get the user selected local video file to upload.
	      File videoFile = new File("res(1).mp4");
	      System.out.println("You chose " + videoFile.getAbsolutePath() + " to upload.");

	      // Add extra information to the video before uploading.
	      Video videoObjectDefiningMetadata = new Video();

	      VideoStatus status = new VideoStatus();
	      status.setPrivacyStatus("public");
	      videoObjectDefiningMetadata.setStatus(status);

	      // We set a majority of the metadata with the VideoSnippet object.
	      VideoSnippet snippet = new VideoSnippet();

	      Calendar cal = Calendar.getInstance();
	      snippet.setTitle("Test Upload via Java on " + cal.getTime());
	      snippet.setDescription(
	          "Video uploaded via YouTube Data API V3 using the Java library " + "on " + cal.getTime());

	      // Set your keywords.
	      List<String> tags = new ArrayList<String>();
	      tags.add("test");
	      tags.add("example");
	      tags.add("java");
	      tags.add("YouTube Data API V3");
	      tags.add("erase me");
	      snippet.setTags(tags);

	      // Set completed snippet to the video object.
	      videoObjectDefiningMetadata.setSnippet(snippet);

	      InputStreamContent mediaContent = new InputStreamContent( VIDEO_FILE_FORMAT, new BufferedInputStream(new FileInputStream(videoFile)));
	      mediaContent.setLength(videoFile.length());

	      YouTube.Videos.Insert videoInsert = youtube.videos()
	          .insert("snippet,statistics,status", videoObjectDefiningMetadata, mediaContent);

	      // Set the upload type and add event listener.
	      MediaHttpUploader uploader = videoInsert.getMediaHttpUploader();

	      uploader.setDirectUploadEnabled(false);

	      MediaHttpUploaderProgressListener progressListener = new MediaHttpUploaderProgressListener() {
	        public void progressChanged(MediaHttpUploader uploader) throws IOException {
	          switch (uploader.getUploadState()) {
	            case INITIATION_STARTED:
	              System.out.println("Initiation Started");
	              break;
	            case INITIATION_COMPLETE:
	              System.out.println("Initiation Completed");
	              break;
	            case MEDIA_IN_PROGRESS:
	              System.out.println("Upload in progress");
	              System.out.println("Upload percentage: " + uploader.getProgress());
	              break;
	            case MEDIA_COMPLETE:
	              System.out.println("Upload Completed!");
	              break;
	            case NOT_STARTED:
	              System.out.println("Upload Not Started!");
	              break;
	          }
	        }
	      };
	      uploader.setProgressListener(progressListener);

	      // Execute upload.
	      Video returnedVideo = videoInsert.execute();

	      // Print out returned results.
	      System.out.println("\n================== Returned Video ==================\n");
	      System.out.println("  - Id: " + returnedVideo.getId());
	      r.put("id", returnedVideo.getId());
	      System.out.println("  - Title: " + returnedVideo.getSnippet().getTitle());
	      System.out.println("  - Tags: " + returnedVideo.getSnippet().getTags());
	      System.out.println("  - Privacy Status: " + returnedVideo.getStatus().getPrivacyStatus());
	      //System.out.println("  - Video Count: " + returnedVideo.getStatistics().getViewCount());

	    } catch (GoogleJsonResponseException e) {
	      System.err.println("GoogleJsonResponseException code: " + e.getDetails().getCode() + " : "
	          + e.getDetails().getMessage());
	      e.printStackTrace();
	    } catch (IOException e) {
	      System.err.println("IOException: " + e.getMessage());
	      e.printStackTrace();
	    } catch (Throwable t) {
	      System.err.println("Throwable: " + t.getMessage());
	      t.printStackTrace();
	    }
		//ajax 뽑는 값
	    System.out.println(r);
		return r;
	}
	
	//유투브 업로드 결과 페이지
	@RequestMapping(value = "/t2", method= RequestMethod.GET)
	public String a11(@RequestParam String ytbID, Model model){
		model.addAttribute("ytbID", ytbID);
		return "side";
	}
	
	// findid
	@RequestMapping(value = "/test", method=RequestMethod.GET)
	public String findidPage(Model model){
		ModelAndView mv = new ModelAndView();
		//Test t = new Test();
		//String a = t.returnedUrl();
		
		// Scope required to upload to YouTube.
	    List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube.upload");

	    try {
	      // Authorization.
	      Credential credential = Auth.authorize(scopes);

	      // YouTube object used to make all API requests.
	      youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, credential).setApplicationName(
	          "youtube-cmdline-uploadvideo-sample").build();
	      
	      // We get the user selected local video file to upload.
	      File videoFile = new File("res(1).mp4");
	      System.out.println("You chose " + videoFile.getAbsolutePath() + " to upload.");

	      // Add extra information to the video before uploading.
	      Video videoObjectDefiningMetadata = new Video();

	      VideoStatus status = new VideoStatus();
	      status.setPrivacyStatus("public");
	      videoObjectDefiningMetadata.setStatus(status);

	      // We set a majority of the metadata with the VideoSnippet object.
	      VideoSnippet snippet = new VideoSnippet();

	      Calendar cal = Calendar.getInstance();
	      snippet.setTitle("Test Upload via Java on " + cal.getTime());
	      snippet.setDescription(
	          "Video uploaded via YouTube Data API V3 using the Java library " + "on " + cal.getTime());

	      // Set your keywords.
	      List<String> tags = new ArrayList<String>();
	      tags.add("test");
	      tags.add("example");
	      tags.add("java");
	      tags.add("YouTube Data API V3");
	      tags.add("erase me");
	      snippet.setTags(tags);

	      // Set completed snippet to the video object.
	      videoObjectDefiningMetadata.setSnippet(snippet);

	      InputStreamContent mediaContent = new InputStreamContent( VIDEO_FILE_FORMAT, new BufferedInputStream(new FileInputStream(videoFile)));
	      mediaContent.setLength(videoFile.length());

	      YouTube.Videos.Insert videoInsert = youtube.videos()
	          .insert("snippet,statistics,status", videoObjectDefiningMetadata, mediaContent);

	      // Set the upload type and add event listener.
	      MediaHttpUploader uploader = videoInsert.getMediaHttpUploader();

	      uploader.setDirectUploadEnabled(false);

	      MediaHttpUploaderProgressListener progressListener = new MediaHttpUploaderProgressListener() {
	        public void progressChanged(MediaHttpUploader uploader) throws IOException {
	          switch (uploader.getUploadState()) {
	            case INITIATION_STARTED:
	              System.out.println("Initiation Started");
	              break;
	            case INITIATION_COMPLETE:
	              System.out.println("Initiation Completed");
	              break;
	            case MEDIA_IN_PROGRESS:
	              System.out.println("Upload in progress");
	              System.out.println("Upload percentage: " + uploader.getProgress());
	              break;
	            case MEDIA_COMPLETE:
	              System.out.println("Upload Completed!");
	              break;
	            case NOT_STARTED:
	              System.out.println("Upload Not Started!");
	              break;
	          }
	        }
	      };
	      uploader.setProgressListener(progressListener);

	      // Execute upload.
	      Video returnedVideo = videoInsert.execute();

	      // Print out returned results.
	      System.out.println("\n================== Returned Video ==================\n");
	      System.out.println("  - Id: " + returnedVideo.getId());
	      System.out.println("  - Title: " + returnedVideo.getSnippet().getTitle());
	      System.out.println("  - Tags: " + returnedVideo.getSnippet().getTags());
	      System.out.println("  - Privacy Status: " + returnedVideo.getStatus().getPrivacyStatus());
	      //System.out.println("  - Video Count: " + returnedVideo.getStatistics().getViewCount());

	    } catch (GoogleJsonResponseException e) {
	      System.err.println("GoogleJsonResponseException code: " + e.getDetails().getCode() + " : "
	          + e.getDetails().getMessage());
	      e.printStackTrace();
	    } catch (IOException e) {
	      System.err.println("IOException: " + e.getMessage());
	      e.printStackTrace();
	    } catch (Throwable t) {
	      System.err.println("Throwable: " + t.getMessage());
	      t.printStackTrace();
	    }
		
		return "find";
	}
	 
}
