package ${package}.app.conf;

import io.tesler.core.controller.http.StaticRedirectFilter;
import javax.servlet.Filter;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@EnableWebSecurity
@Order(1)
public class ${appUpperCaseName}RedirectConfig extends WebSecurityConfigurerAdapter {

	private final ${appUpperCaseName}Configuration configuration;

	public ${appUpperCaseName}RedirectConfig(${appUpperCaseName}Configuration configuration) {
		super(true);
		this.configuration = configuration;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.requestMatchers()
				.antMatchers("/").and()
				.addFilterBefore(defaultUrlFilter(), ChannelProcessingFilter.class)
			.authorizeRequests()
				.antMatchers("/").permitAll();
		// @formatter:on
	}

	private Filter defaultUrlFilter() {
		return new StaticRedirectFilter(String.format("%s/", configuration.getUiPath()));
	}

}
