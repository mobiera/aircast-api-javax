package com.mobiera.ms.mno.aircast.res.s;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mobiera.aircast.api.vo.EndpointVO;
import com.mobiera.aircast.api.vo.IdentifierVO;
import com.mobiera.aircast.api.vo.LandingVO;
import com.mobiera.aircast.api.vo.ParameterVO;
import com.mobiera.aircast.api.vo.PricepointVO;
import com.mobiera.aircast.api.vo.VaServiceVO;
import com.mobiera.aircast.commons.enums.EndpointType;
import com.mobiera.aircast.commons.enums.PricepointType;
import com.mobiera.aircast.commons.enums.VaServiceType;
import com.mobiera.commons.api.RegisterRequest;
import com.mobiera.commons.api.RegisterResponse;
import com.mobiera.commons.enums.EntityState;
import com.mobiera.commons.exception.ClientException;
import com.mobiera.ms.mno.aircast.svc.ParameterResourceInterface;


public interface PmVasResourceInterface extends ParameterResourceInterface {


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/register")
	RegisterResponse registerRequest(RegisterRequest re) throws ClientException;
	
	
	@GET
	@Path("/pricepoint/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public PricepointVO getPricepoint(@PathParam(value="id") Long id);
	
	@GET
	@Path("/va_service/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public VaServiceVO getVaService(@PathParam(value="id") Long id);
	
	@GET
	@Path("/identifier/name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public IdentifierVO getFirstIdentifierWithName(@PathParam(value="name") String name);
	
	
	
	@GET
	@Path("/pricepoints")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PricepointVO> listPricepoints(@QueryParam(value="type") PricepointType type, 
			@QueryParam(value="vaServiceFk") Long vaServiceFk );
	
	
	@GET
	@Path("/parameter/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public ParameterVO getParameterRequest(@PathParam(value = "name") String name);
	
	@GET
	@Path("/identifier/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public IdentifierVO getIdentifier(@PathParam(value="id") Long id);
	
	
	@GET
	@Path("/identifiers/pricepoint/{pricepoint}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<IdentifierVO> listIdentifiersForPricepoint(
			@PathParam(value="pricepoint") Long pricepoint);

	@GET
	@Path("/endpoints/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EndpointVO> listEndpoints(
			@PathParam(value="type") EndpointType type, @QueryParam(value = "state") EntityState state);
	
	@GET
	@Path("/endpoint/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public EndpointVO getEndpoint(@PathParam(value="id") Long id);
	
	
	@GET
	@Path("/va_services")
	@Produces(MediaType.APPLICATION_JSON)
	public List<VaServiceVO> listVaServices(@QueryParam(value="type") VaServiceType type, 
			@QueryParam(value="state") EntityState state);


	
	
	@GET
	@Path("/landing/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public LandingVO getLanding(@PathParam(value="id") Long id); 
	
	@GET
	@Path("/landings/pricepoint/{pricepoint}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LandingVO> listLandingsForPP(
			@PathParam(value="pricepoint") Long pricepoint
			
			);
	
	
}
