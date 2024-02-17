package com.hive.app.kafka;

import java.util.Properties;

public class KafkaProducerPropertiesBuilder {
	
	private final Properties props;

	private KafkaProducerPropertiesBuilder(Properties props) {
		this.props = props;
	}

	public static class Builder {
		
		private final Properties props = new Properties();

		public Builder bootstrapServers(String servers) {
			props.put("bootstrap.servers", servers);
			return this;
		}

		public Builder keySerializer(String serializer) {
			props.put("key.serializer", serializer);
			return this;
		}

		public Builder valueSerializer(String serializer) {
			props.put("value.serializer", serializer);
			return this;
		}

		public KafkaProducerPropertiesBuilder build() {
			return new KafkaProducerPropertiesBuilder(props);
		}
	}

	public Properties getProperties() {
		return props;
	}
}
