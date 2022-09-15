package ilayda.core.adapters;

import java.io.IOException;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import ilayda.core.utilities.result.ErrorResult;
import ilayda.entities.concretes.JobSeeker;

public class Verification {
private JobSeeker jobseeker;
	
	public Verification(	JobSeeker jobseeker) {
		this.jobseeker=jobseeker;
	}
	
	
	public boolean isCorrect() throws IOException{
		//vatandaşlık doğrulaması
		OkHttpClient client = new OkHttpClient();
				MediaType mediaType = MediaType.parse("application/soap+xml; charset=utf-8");
				RequestBody body = RequestBody.create(mediaType, "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\r\n  <soap12:Body>\r\n    <TCKimlikNoDogrula xmlns=\"http://tckimlik.nvi.gov.tr/WS\">\r\n      <TCKimlikNo>"+jobseeker.getIdentityNo()+"</TCKimlikNo>\r\n      <Ad>"+jobseeker.getName()+"</Ad>\r\n      <Soyad>"+jobseeker.getSurname()+"</Soyad>\r\n      <DogumYili>"+jobseeker.getBirthyear()+"</DogumYili>\r\n    </TCKimlikNoDogrula>\r\n  </soap12:Body>\r\n</soap12:Envelope>");
				Request request = new Request.Builder()
				  .url("https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx")
				  .method("POST", body)
				  .addHeader("Content-Type", "application/soap+xml; charset=utf-8")
				  .addHeader("Cookie", "TS01326bb0=0179b2ce45701c55f5af7da03607a40704752523f1202634f48a524a8e0b5411566ca6a25f629c90b09ccc79d5da49eb0c0713478a")
				  .build();
				Response response = client.newCall(request).execute();
	
			if( (response.body().string()).contains("true")&& !jobseeker.getName().isEmpty()&& !jobseeker.getSurname().isEmpty()&& !jobseeker.getIdentityNo().isEmpty()&& !((String.valueOf(jobseeker.getBirthyear())).isEmpty())&&passwordmatch()) {
				return true;
			}
			else return false;
	//		System.out.println(response.body().string());
	
	}

	//eposta formatı doğrulaması 
	    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        if(!m.matches()) new ErrorResult("Geçerli bir eposta giriniz.");
        System.out.println("sdmvlvsm");
        return m.matches();
 }

	    //şifre uyuşması kontrolü
    public boolean passwordmatch() {
    	if(jobseeker.getPassword().equals(jobseeker.getPassword2())) {
    		return true;
    	}
    	
    	else {
    		new ErrorResult("Şifreler uyuşmamaktadır.");
    		return false;
    	
    	}
    }
    
    
}


