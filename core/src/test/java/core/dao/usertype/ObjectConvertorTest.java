package core.dao.usertype;

import com.java.training.core.usertype.ObjectConvertor;
import org.fest.assertions.Assertions;
import org.junit.Test;

import java.io.Serializable;

public class ObjectConvertorTest  {

    @Test
    public void shouldConvertObjectToBytesAndConvertToObjectSuccess() {

        SerializedObject serializedObject = new SerializedObject();
        serializedObject.name = "Name 1";
        serializedObject.id = "Id 1";

        byte[] bytes = ObjectConvertor.convertToBytes(serializedObject);
        SerializedObject result = (SerializedObject)ObjectConvertor.convertToObject(bytes);
        Assertions.assertThat(result.name).isEqualTo(serializedObject.name);
        Assertions.assertThat(result.id).isEqualTo(serializedObject.id);
    }

    private static class SerializedObject implements Serializable {

        private String name;
        private String id;
    }
}