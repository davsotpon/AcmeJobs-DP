
package acme.features.anonymous.garciaBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.GarciaBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousGarciaBulletinListService implements AbstractListService<Anonymous, GarciaBulletin> {

	@Autowired
	AnonymousGarciaBulletinRepository repository;


	@Override
	public boolean authorise(final Request<GarciaBulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<GarciaBulletin> request, final GarciaBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "moment", "sport", "author", "description");
	}

	@Override
	public Collection<GarciaBulletin> findMany(final Request<GarciaBulletin> request) {
		assert request != null;
		Collection<GarciaBulletin> result;
		result = this.repository.findMany();

		return result;
	}

}
