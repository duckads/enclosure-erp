package kr.co.shield.ext;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Transient;
import kr.co.shield.common.ShieldProperty;
import kr.co.shield.utility.StringUtils;

import java.util.Map;

public abstract class Option implements OptionKey {
	
	@JsonIgnore
	@Transient
	private Map<String, Object> optionMap;
	
	protected abstract String getOption();
	protected abstract void setOption(String option);
	
	@SuppressWarnings("unchecked")
	public void mapping() {
		if (this.optionMap == null) {
			this.optionMap = ShieldProperty.GSON.fromJson(StringUtils.getString(getOption(), "{}"), Map.class);
		}
	}
	
	public Map<String, Object> getOptionMap() {
		mapping();
		return this.optionMap;
	}
	
	public boolean hasOption(String key) {
		mapping();
		return this.optionMap.containsKey(key);
	}
	
	public Object getOption(String key) {
		mapping();
		return this.optionMap.getOrDefault(key, null);
	}
	public String getOptionString(String key) {
		return StringUtils.getString(getOption(key));
	}
	
	public void putOption(String key, Object value) {
		mapping();
		this.optionMap.put(key, value);
		setOption(ShieldProperty.GSON.toJson(this.optionMap));
	}
	public void removeOption(String key) {
		mapping();
		if (this.optionMap.containsKey(key)) {
			this.optionMap.remove(key);
			setOption(ShieldProperty.GSON.toJson(this.optionMap));
		}
	}
	
}
