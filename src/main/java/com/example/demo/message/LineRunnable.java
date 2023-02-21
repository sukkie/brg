/*
 *  Copyright 2016 Scouter Project.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); 
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License. 
 *  
 *  @author Sang-Cheon Park
 */
package com.example.demo.message;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class LineRunnable implements Runnable {
	
	private String name;
	private String date;
	private String url;
	
	public LineRunnable(String name, String date, String url) {
		this.name = name;
		this.date = date;
		this.url = url;
	}

	public void run() {
		try {
			// Get server configurations for line
			String token = "ZMoo97YR73PtTXLMuMdmGwFfwXcCGEvc1EguhKxMddPEgCip+P3pzRrrN1QYzdHK5v3231MkPEnznnFm3zI8kg93l1N0yjiHf558O5P/Vn/a070WxkaD/dk4R65Y1Dbr5rJAhAiV3206bo3pM9EccwdB04t89/1O/w1cDnyilFU=";
			String chatId = "U46f63626c23d87841fa2e3b95c10f6a5";

			assert token != null;
			assert chatId != null;

			// Make a request URL using telegram bot api
			String url = "https://api.line.me/v2/bot/message/push";


			// Make message contents
			String contents =  this.name + "\n"
					+ this.date + "\n"
					+ this.url;

			LinePushFormat pushFormat = new LinePushFormat();
			pushFormat.setTo(chatId);
			pushFormat.addMessage(new StringMessage(contents));

			String body = new Gson().toJson(pushFormat);

			HttpPost post = new HttpPost(url);
			post.addHeader("Content-Type", "application/json");
			post.addHeader("Authorization", "Bearer {" + token + "}");
			post.setEntity(new StringEntity(body, "UTF-8"));

			CloseableHttpClient client = HttpClientBuilder.create().build();

			// send the post request
			HttpResponse response = client.execute(post);

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				System.out.println("Line message sent to [" + chatId + "] successfully.");
			} else {
				System.out.println("Line message sent failed. Verify below information.");
				System.out.println("[URL] : " + url);
				System.out.println("[Message] : " + body);
				System.out.println("[Reason] : " + EntityUtils.toString(response.getEntity(), "UTF-8"));
			}
		} catch (Exception e) {
			System.err.println("[Error] : " + e.getMessage());
		}
	}
}
