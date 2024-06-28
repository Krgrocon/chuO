//package DSA.chuO.service;
//
//import DSA.chuO.model.ChatMessage;
//import com.google.firebase.database.ChildEventListener;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class ChatService {
//    private DatabaseReference database;
//
//    public ChatService() {
//        database = FirebaseDatabase.getInstance().getReference().child("messages");
//    }
//
//    public void sendMessage(ChatMessage message) {
//        Map<String, Object> messageMap = new HashMap<>();
//        messageMap.put("content", message.getContent());
//        messageMap.put("sender", message.getSender());
//
//        database.push().setValueAsync(messageMap);
//    }
//
//    public void addMessageListener(ChildEventListener listener) {
//        database.addChildEventListener(listener);
//    }
//
//    // 메시지를 가져오는 메서드는 비동기적으로 처리해야 하므로, 이를 처리하는 방법은 애플리케이션의 요구 사항에 따라 다릅니다.
//}
//
//
