package es.us.isa.botica.util.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;

/**
 * Configuration loader for YAML and JSON formats using Jackson
 *
 * @author Alberto Mimbrero
 */
public class JacksonConfigurationFileLoader implements ConfigurationFileLoader {
  private final ObjectMapper mapper =
      new ObjectMapper(new YAMLFactory())
          .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

  @Override
  public <T extends Configuration> T load(File file, Class<T> configurationFileClass) {
    try {
      return mapper.readValue(file, configurationFileClass);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
