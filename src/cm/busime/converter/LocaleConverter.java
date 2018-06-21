package cm.busime.converter;

import java.io.Serializable;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import cm.busime.domain.Local;
import cm.busime.model.LocaleService;

@FacesConverter(value = "cm.busime.converter.LocaleConverter")
public class LocaleConverter implements Converter, Serializable{
	
	private static final long serialVersionUID = -9138002346170553295L;
	
	@Inject
	LocaleService localeService;

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
        List<Local> locales = localeService.getLocals();
        for (Local local : locales) {
            if (local.getName().equals(value)) {
                return local;
            }
        }
        
        return null;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		//return ((Local) value).toString();
		Local l = (Local) value;
		return "Local [id=" + l.getId() + ", Name=" + l.getName() + ", icon=" + l.getIcon() + "]";
	}
}
